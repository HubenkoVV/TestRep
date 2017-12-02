package ua.training.Builder;

public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder().buildMark("BMW").buildMaxSpeed(200).buildTramsmission(Transmission.AUTO).build();
        System.out.println(car.toString());
    }
}

enum Transmission{
    MANUAL, AUTO
}

//Product
class Car{
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

class CarBuilder{
    private String mark = "default";
    private Transmission tramsmission = Transmission.MANUAL;
    private int maxSpeed = 120;

    CarBuilder buildMark(String mark) {
        this.mark = mark;
        return this;
    }

    CarBuilder buildTramsmission(Transmission tramsmission) {
        this.tramsmission = tramsmission;
        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(mark);
        car.setMaxSpeed(maxSpeed);
        car.setTramsmission(tramsmission);
        return car;
    }
}
