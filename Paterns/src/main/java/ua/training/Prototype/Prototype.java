package ua.training.Prototype;

public class Prototype {
    public static void main(String[] args){
        Human original = new Human(10, "Nadya");
        System.out.println(original);

        Human copy = original.copy();
        System.out.println(copy);

        HumanFactory humanFactory = new HumanFactory(copy);
        Human human = humanFactory.makeCopy();
        System.out.println(human);

        Human h = new Human(50,"Vova");
        System.out.println(h);
        humanFactory.setPrototype(h);
        Human human1 = humanFactory.makeCopy();
        System.out.println(human1);

    }
}

interface Copyable<T>{
    T copy();
}

class Human implements Copyable{
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public Human copy() {
        return new Human(age, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory{
    Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    void setPrototype(Human human){
        this.human = human;
    };

    Human makeCopy(){
        return human.copy();
    }
}