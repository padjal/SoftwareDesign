import annotations.Exported;
import annotations.Ignored;
import annotations.PropertyName;
import exceptions.NotExportedException;
import exceptions.YamlSerializationException;
import interfaces.Mapper;
import org.apache.commons.lang3.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class YamlMapper implements Mapper {
    boolean retainIdentity;
    StringBuilder stringBuilder;
    int indent = 0;

    public YamlMapper(boolean retainIdentity){
        this.retainIdentity = retainIdentity;
    }

    public YamlMapper(){

    }

    public boolean getRetainIdentity(){
        return retainIdentity;
    }

    public void setRetainIdentity(boolean value){
        retainIdentity = value;
    }

    /**
     * Читает сохранённый экземпляр класса {@code clazz} из строки {@code input}
     * и возвращает восстановленный экземпляр класса {@code clazz}.
     * <p>
     * Пример вызова:
     *
     * <pre>
     *
     * String input = """
     *
     * {"comment":"Хорошая работа","resolved":false}""";
     *
     * ReviewComment reviewComment =
     * mapper.readFromString(ReviewComment.class, input);
     *
     * System.out.println(reviewComment);
     * </pre>
     *
     * @param clazz класс, сохранённый экземпляр которого находится в {@code input}
     * @param input строковое представление сохранённого экземпляра класса {@code
     *              clazz}
     * @return восстановленный экземпляр {@code clazz}
     */
    @Override
    public <T> T readFromString(Class<T> clazz, String input) {
        return null;
    }

    /**
     * Читает объект класса {@code clazz} из {@code InputStream}'а
     * и возвращает восстановленный экземпляр класса {@code clazz}.
     * <p>
     * Данный метод закрывает {@code inputStream}.
     * <p>
     * Пример вызова:
     *
     * <pre>
     *
     * String input = """
     *
     * {"comment":"Хорошая работа","resolved":false}""";
     *
     * ReviewComment reviewComment = mapper.read(ReviewComment.class,
     *
     * new
     * ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
     *
     * System.out.println(reviewComment);
     * </pre>
     *
     * @param clazz       класс, сохранённый экземпляр которого находится в {@code
     *                    inputStream}
     * @param inputStream поток ввода, содержащий строку в {@link
     *                    StandardCharsets#UTF_8} кодировке
     *                    5* @param <T> возвращаемый тип метода
     * @return восстановленный экземпляр класса {@code clazz}
     * @throws IOException в случае ошибки ввода-вывода
     */
    @Override
    public <T> T read(Class<T> clazz, InputStream inputStream) throws IOException {
        return null;
    }

    /**
     * Читает сохранённое представление экземпляра класса {@code clazz} из {@code
     * File}'а
     * и возвращает восстановленный экземпляр класса {@code clazz}.
     * <p>
     * Пример вызова:
     *
     * <pre>
     *
     * ReviewComment reviewComment = mapper.read(ReviewComment.class, new
     * File("/tmp/review"));
     *
     * System.out.println(reviewComment);
     * </pre>
     *
     * @param clazz класс, сохранённый экземпляр которого находится в файле
     * @param file  файл, содержимое которого - строковое представление экземпляра
     *              {@code clazz}
     *              в {@link StandardCharsets#UTF_8} кодировке
     * @return восстановленный экземпляр {@code clazz}
     * @throws IOException в случае ошибки ввода-вывода
     */
    @Override
    public <T> T read(Class<T> clazz, File file) throws IOException {
        return null;
    }

    /**
     * Сохраняет {@code object} в строку
     * <p>
     * Пример вызова:
     *
     * <pre>
     *
     * ReviewComment reviewComment = new ReviewComment();
     *
     * reviewComment.setComment("Хорошая работа");
     *
     * reviewComment.setResolved(false);
     *
     *
     * String string = mapper.writeToString(reviewComment);
     *
     * System.out.println(string);
     * </pre>
     *
     * @param object объект для сохранения
     * @return строковое представление объекта в выбранном формате
     * @throws NotExportedException when the object is not marked with @Exported
     */
    @Override
    public String writeToString(Object object) {
        if(object.getClass().getAnnotation(Exported.class) == null){
            throw new NotExportedException("Object is not marked as exported!");
        }

        stringBuilder = new StringBuilder();

        for (var field : object.getClass().getDeclaredFields()) {
            try {
                var serializedField = serializeField(field, object);

                if (serializedField != null){
                    stringBuilder
                            .append(getIndentation())
                            .append(serializedField)
                            .append("\n");
                }
            }catch (IllegalAccessException e){
                throw new YamlSerializationException("Illegal access", e.getCause());
            }
        }

        return stringBuilder.toString();
    }

    private String getIndentation(){
        var sb = new StringBuilder();

        for (int i = 0; i < indent; i++){
            sb.append("  ");
        }

        return sb.toString();
    }

    private String serializeField(Field field, Object object) throws IllegalAccessException{
        field.trySetAccessible();

        if (field.isAnnotationPresent(Ignored.class)){
            return null;
        }

        var propertyName = field.isAnnotationPresent(PropertyName.class) ?
                field.getAnnotation(PropertyName.class).value() :
                field.getName();

        var propertyValue = field.get(object);

        if(propertyValue == null){
            switch (object.getClass().getAnnotation(Exported.class).nullHandling()){
                case EXCLUDE -> {return null;}
                case INCLUDE -> {return propertyName + ": null";}
            }
        }

        if (ClassUtils.isPrimitiveOrWrapper(propertyValue.getClass()) || propertyValue instanceof String){
            return propertyName + ": " + propertyValue;
        }else{
            return propertyName + ": " + serializeObject(propertyValue);
        }
    }

    private String serializeObject(Object object){
        if(object.getClass().getAnnotation(Exported.class) == null){
            throw new NotExportedException("Object is not marked as exported!");
        }

        var sb = new StringBuilder();

        if (object instanceof Collection collection){
            indent++;
            sb.append("n");

            for (var elem : collection) {
                sb.append("- ");

                sb.append("\n");
            }
        }

        for (var field : object.getClass().getDeclaredFields()) {
            try {
                var serializedField = serializeField(field, object);

                if (serializedField != null){
                    stringBuilder
                            .append(getIndentation())
                            .append(serializedField)
                            .append("\n");
                }
            }catch (IllegalAccessException e){
                throw new YamlSerializationException("Illegal access", e.getCause());
            }
        }

        return sb.toString();
    }

    /**
     * Сохраняет {@code object} в {@link OutputStream}.
     * <p>
     * 6* То есть после вызова этого метода в {@link OutputStream} должны оказаться
     * байты, соответствующие строковому
     * представлению {@code object}'а в кодировке {@link
     * StandardCharsets#UTF_8}
     * <p>
     * Данный метод закрывает {@code outputStream}
     * <p>
     * Пример вызова:
     *
     * <pre>
     *
     * ReviewComment reviewComment = new ReviewComment();
     *
     * reviewComment.setComment("Хорошая работа");
     *
     * reviewComment.setResolved(false);
     *
     *
     * mapper.write(reviewComment, new FileOutputStream("/tmp/review"));
     * </pre>
     *
     * @param object       объект для сохранения
     * @param outputStream
     * @throws IOException в случае ошибки ввода-вывода
     */
    @Override
    public void write(Object object, OutputStream outputStream) throws IOException {

    }

    /**
     * Сохраняет {@code object} в {@link File}.
     * <p>
     * То есть после вызова этого метода в {@link File} должны оказаться байты,
     * соответствующие строковому
     * представлению {@code object}'а в кодировке {@link
     * StandardCharsets#UTF_8}
     * <p>
     * Данный метод закрывает {@code outputStream}
     * <p>
     * Пример вызова:
     *
     * <pre>
     *
     * ReviewComment reviewComment = new ReviewComment();
     *
     * reviewComment.setComment("Хорошая работа");
     *
     * reviewComment.setResolved(false);
     *
     *
     * mapper.write(reviewComment, new File("/tmp/review"));
     * </pre>
     *
     * @param object объект для сохранения
     * @param file
     * @throws IOException в случае ошибки ввода-вывода
     */
    @Override
    public void write(Object object, File file) throws IOException {

    }
}
