package ua.training.Visitor;

import java.util.Arrays;

public class VisitorApp {
    public static void main(String[] args){
        Visitor visitor = new Mechanic();
        Visitor visitor1 = new Hooligan();
//        Element engineEl = new EngineEl();
//        Element bodyEl = new BodyEl();
//        engineEl.accept(visitor1);
//        engineEl.accept(visitor);
//        bodyEl.accept(visitor1);
//        bodyEl.accept(visitor);
        Element car = new Car();
        car.accept(visitor1);
        car.accept(visitor);
    }
}

interface Visitor{
    void visit(EngineEl engine);
    void visit(BodyEl body);
    void visit(Car car);
    void visit(WheelEl wheelEl);
}

class Hooligan implements Visitor{

    @Override
    public void visit(EngineEl engine) {
        System.out.println("Broke the engine ");
    }

    @Override
    public void visit(BodyEl body) {
        System.out.println("Broke the body ");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Broke the car");
    }

    @Override
    public void visit(WheelEl wheelEl) {
        System.out.println("Broke the "+ wheelEl.getName() + " wheel");
    }
}

class Mechanic implements Visitor{

    @Override
    public void visit(EngineEl engine) {
        System.out.println("Fixed the engine");
    }

    @Override
    public void visit(BodyEl body) {
        System.out.println("Fixed the body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Fixed the car");
    }

    @Override
    public void visit(WheelEl wheelEl) {
        System.out.println("Fixed the "+ wheelEl.getName() +" wheel");
    }
}

interface Element{
    void accept(Visitor visitor);
}

class EngineEl implements Element{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyEl implements Element{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WheelEl implements Element{
    private String name;

    public WheelEl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Car implements Element{
    Element[] elements;

    public Car(){
        elements = new Element[]{new WheelEl("first left"), new WheelEl("second left"), new WheelEl("first right")
                , new WheelEl("second right") , new EngineEl() , new BodyEl()};
    }

    @Override
    public void accept(Visitor visitor) {
        Arrays.asList(elements).forEach(element -> element.accept(visitor));
        visitor.visit(this);
    }
}