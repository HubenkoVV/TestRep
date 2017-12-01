package ua.training.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Composite composite = new Composite();
        composite.addComponent(new Square());
        composite.addComponent(new Circle());
        composite.addComponent(new Square());

        Composite composite2 = new Composite();
        composite2.addComponent(new Square());
        composite2.addComponent(new Triangle());
        composite2.addComponent(composite);

        Composite composite3 = new Composite();
        composite3.addComponent(composite2);
        composite3.addComponent(new Circle());
        composite3.addComponent(new Circle());

        composite3.draw();


    }
}

interface Shape{
    void draw();
}
class Circle implements Shape{

    public void draw() {
        System.out.println("Circle");
    }
}

class Triangle implements Shape{

    public void draw() {
        System.out.println("Triangle");
    }
}

class Square implements Shape{

    public void draw() {
        System.out.println("Square");
    }
}

class Composite implements Shape{

    List<Shape> components = new ArrayList<Shape>();

    public void addComponent(Shape shape){
        components.add(shape);
    }

    public void removeComponent(Shape shape){
        components.remove(shape);
    }

    public void draw() {
        components.forEach(component -> component.draw());
    }
}