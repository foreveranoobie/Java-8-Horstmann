package test;

public class Test {
    public static void main(String... args){
        A a = new A();
        a.setNumber(1);
        B b = new B();
        b.setNumber(2);
        doSmtA(a);
        doSmtA(b);
    }

    public static void doSmtA(A a){
        System.out.println(a.getNumber());
    }

}
