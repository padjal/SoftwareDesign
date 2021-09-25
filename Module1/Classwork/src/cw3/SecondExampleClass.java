package cw3;

public class SecondExampleClass {
    public static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass(3, 5.6);
        exampleClass.a = 4;
        // exampleClass.b = 4.5; B is not accessible (private)

        exampleClass.setB(4.5); // Can change a private property with method.
    }
}
