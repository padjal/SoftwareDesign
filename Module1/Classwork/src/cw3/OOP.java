package cw3;

public class OOP {
    // Encapsulation - bundling of data, along with the methods
    // that operate on that data, into a single unit.
    //
    // Inheritance - code reusing, hierarchical object structure.
    //
    // Abstraction
    //
    // Polymorphism

    public static void main(String[] args) {
        DerivedClass derivedClass = new DerivedClass();
        ExampleClass exampleClass = new ExampleClass();
        ExampleClass check = new DerivedClass();

        derivedClass.Hello();
        exampleClass.Hello();
        check.Hello();
    }
}
