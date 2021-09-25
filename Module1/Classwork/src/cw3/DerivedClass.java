package cw3;

public class DerivedClass extends ExampleClass{
    public DerivedClass() {
        // Super is used to refer to the parent object and use its contructors, properties and methods.
        super(10, 4.5);
        super.setB(30);
    }

    public static void main(String[] args) {
        DerivedClass derivedClass = new DerivedClass();
        System.out.println(derivedClass.getB());

        StaticClass.Hello(450);
    }

    // Used to override methods.
    @Override
    public void setB(double b) {
        super.setB(b+10);
    }

    @Override
    public void Hello() {
        System.out.println("Derived class.");
    }
}
