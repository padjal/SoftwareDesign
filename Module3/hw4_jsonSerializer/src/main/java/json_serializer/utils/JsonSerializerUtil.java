package json_serializer.utils;

import json_serializer.annotations.IgnoreNull;
import json_serializer.annotations.JsonElement;
import json_serializer.annotations.JsonSerializable;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class JsonSerializerUtil {

    public String serialize(Object object) throws JsonSerializeException{
        if(!object.getClass().isAnnotationPresent(JsonSerializable.class)){
            throw new JsonSerializeException();
        }

        try {
            Class<?> objectClass = requireNonNull(object).getClass();
            LinkedHashMap<String, String> jsonElements = new LinkedHashMap<>();
            boolean ignoreNull = objectClass.isAnnotationPresent(IgnoreNull.class);

            for (Field field: objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonElement.class)) {
                    if(ignoreNull && field.get(object) == null){
                        continue;
                    }

                    var value = field.get(object) != null ? field.get(object).toString() : "null" ;
                    jsonElements.put(getSerializedKey(field), value);
                }
            }

            return toJsonString(jsonElements);
        }catch (Exception exception){
            throw new JsonSerializeException();
        }

    }

    private String toJsonString(LinkedHashMap<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\""  + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonElement.class).value();

        if (annotationValue.isEmpty()) {
            return field.getName();
        }
        else {
            return annotationValue;
        }
    }

    public class JsonSerializeException extends Exception{
        public JsonSerializeException(String errorMessage){
            super(errorMessage);
        }

        public JsonSerializeException(){
        }
    }
}