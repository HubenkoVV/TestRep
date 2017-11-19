package ua.training.lamp.entity;

/**
 * Created by Влада on 15.11.2017.
 */
public class Phone implements ElectricityConsumer {

    private void phoneOn() {
        System.out.println("Phone ON!");
    }
    private void phoneOff() {
        System.out.println("Phone OFF!");
    }

    @Override
    public void electricityOn() {
        phoneOn();
    }

    @Override
    public void electricityOff() {
        phoneOff();
    }
}
