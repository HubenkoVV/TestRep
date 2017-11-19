package ua.training.lamp.entity;

/**
 * Created by Влада on 15.11.2017.
 */
public class Computer implements ElectricityConsumer {

    private void compOn() {
        System.out.println("Computer ON!");
    }
    private void compOff() {
        System.out.println("Computer OFF!");
    }

    @Override
    public void electricityOn() {
        compOn();
    }

    @Override
    public void electricityOff() {
        compOff();
    }
}
