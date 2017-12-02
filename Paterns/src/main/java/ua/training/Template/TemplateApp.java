package ua.training.Template;

public class TemplateApp {
    public static void main(String[] args) {
        A a = new A();
        a.templateMethod();
        System.out.println();
        B b = new B();
        b.templateMethod();
    }
}

//Parent
abstract class C{
    void templateMethod(){
        System.out.print("1");
        differ();
        System.out.print("3");
        differForA();
    }
    abstract void differ();
    abstract void differForA();
}

class A extends C{

    void differ() {
        System.out.print("2");
    }
    void differForA() {
        System.out.print("5");
    }
}

class B extends C{

    void differ() {
        System.out.print("4");
    }

    void differForA() {}
}
