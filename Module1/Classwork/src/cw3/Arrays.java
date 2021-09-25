package cw3;

import java.lang.reflect.Array;

public class Arrays {
    public static void main(String[] args) {
        // Arrays are reference types.
        // They are objects of type Array.

        int[] ints = {1, 4, 3, 4};
        ExampleClass[] exampleClasses = new ExampleClass[100];
        System.out.println(ints.getClass());

        int[] ints2 = new int[2];
        for (int i=0; i<6; i++){
            ints2[i] = i;
        }
    }
}
