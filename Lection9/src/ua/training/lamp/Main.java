package ua.training.lamp;

import ua.training.lamp.entity.*;

import java.util.Arrays;

/**
 * Created by Влада on 15.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Switch sw = new Switch();
        Lamp lamp = new Lamp();
        Computer computer = new Computer();
        Phone phone = new Phone();

        //event subscribe
        sw.setConsumer(new ElectricityConsumer[]{lamp,computer,phone});

        sw.switchOn();
        sw.switchOff();
    }
}
