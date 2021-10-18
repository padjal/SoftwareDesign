package cw5;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Integer a =4;
        Integer b = 8;

        swap(a, b);

        System.out.println(a);
        System.out.println(b);
    }

    static void swap(Integer a, Integer b) throws NoSuchFieldException {
        Integer temp = a;
        a.getClass().getDeclaredField("value").setAccessible(true);
        b.getClass().getDeclaredField("value").setAccessible(true);

        /*a.value = b;
        b.value = temp;*/
    }
}
