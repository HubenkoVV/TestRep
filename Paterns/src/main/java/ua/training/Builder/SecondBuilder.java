package ua.training.Builder;

public class SecondBuilder {
    public static void main(String[] args) {
        Director director = new Director();
        director.setSecondBuilder(new FordBuilder());
        SecondCar secondCar = director.createCar();
        System.out.println(secondCar);

        director.setSecondBuilder(new SubaruBuilder());
        secondCar = director.createCar();
        System.out.println(secondCar);
    }
}

//Product
class SecondCar {
    private String mark;
    private Transmission tramsmission;
    private int maxSpeed;

    void setMake(String mark) {
        this.mark = mark;
    }

    void setTramsmission(Transmission tramsmission) {
        this.tramsmission = tramsmission;
    }

    void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", tramsmission=" + tramsmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class Director{
    private SecondCarBuilder secondBuilder;

    public void setSecondBuilder(SecondCarBuilder secondBuilder) {
        this.secondBuilder = secondBuilder;
    }

    SecondCar createCar(){
        secondBuilder.createCar();

        secondBuilder.buildMark();
        secondBuilder.buildSpeed();
        secondBuilder.buildTransmission();

        return secondBuilder.getCar();

    }
}

//Abstract Builder
abstract class SecondCarBuilder{
    SecondCar car;
    void createCar(){
        car = new SecondCar();
    }

    abstract void buildMark();
    abstract void buildTransmission();
    abstract void buildSpeed();

    SecondCar getCar(){return car;};
}
//ConcreteBuilder
class FordBuilder extends SecondCarBuilder{

    void buildMark(){
        car.setMake("Ford");
    };
    void buildTransmission(){
        car.setTramsmission(Transmission.AUTO);
    };
    void buildSpeed(){
        car.setMaxSpeed(190);
    };
}

//ConcreteBuilder
class SubaruBuilder extends SecondCarBuilder{

    void buildMark(){
        car.setMake("Subaru");
    };
    void buildTransmission(){
        car.setTramsmission(Transmission.AUTO);
    };
    void buildSpeed(){
        car.setMaxSpeed(170);
    };
}
