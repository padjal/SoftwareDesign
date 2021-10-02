package cw4;

public class FinalExample {
    public int sampleMethod(){
        final int a = 5;
        // a = 4;
        // Cannot be changed
        B b = null;
        b.method();

        return a;
    }
}

class B{
    static void method(){

    }
}
