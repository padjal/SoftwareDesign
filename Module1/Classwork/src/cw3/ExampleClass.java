package cw3;

public class ExampleClass {
    // Properties (States)

    // ACCESS MODIFIERS
    // private - only within current class
    // protected - only within package and derived classes
    // public  - available to all
    // default - always within package
    // final - Can only receive value once. Usually in constructor.
    public int a;
    private double b;

    //Main rule - always use the most restricted access.

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    //Constructors

    public ExampleClass(int a, double b) {
        this.a = a;
        this.b = b;
    }

    public ExampleClass() {
    }

    //Methods

    public void Hello(){
        System.out.println("ExampleClass.");
    }

    public static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.b = 5.0;
    }
}
