package ua.training.Delegate;

public class DelegateApp {
    public static void main(String[] args) {
//        A a = new A();
//        a.f();
//        B b = new B();
//        b.f();
        Painter p = new Painter();
        p.setGraphics(new Circle());
        p.draw();
        p.setGraphics(new Triangle());
        p.draw();
    }
}

class A{
    void f(){
        System.out.println("f()");/*
         *
         *
         *
         *
         */
    }
}
class B{
    A a = new A();
    void f(){
        a.f();
    }
}

interface Graphics{
    void draw();
}
class Triangle implements Graphics{
    public void draw() {
        System.out.println("Draw triangle");
    }
}
class Square implements Graphics{
    public void draw() {
        System.out.println("Draw square");
    }
}
class Circle implements Graphics{
    public void draw() {
        System.out.println("Draw circle");
    }
}

class Painter{
    Graphics g;
    //мутатор
    void setGraphics(Graphics g){
        this.g = g;
    }

    void draw(){
        g.draw();
    }
}
