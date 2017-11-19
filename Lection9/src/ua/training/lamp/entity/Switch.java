package ua.training.lamp.entity;

import java.util.ArrayList;

/**
 * Created by Влада on 15.11.2017.
 */
public class Switch {
    private ElectricityConsumer[] consumers;

    public ElectricityConsumer[] getConsumers() {
        return consumers;
    }

    public void setConsumer(ElectricityConsumer[] consumers) {
        this.consumers = consumers;
    }

    public void switchOn() {
        System.out.println("Switch ON!");
        if (consumers.length != 0){
            for (ElectricityConsumer consumer: consumers) {
                consumer.electricityOn();
            }
        }
    }

    public void switchOff() {
        System.out.println("Switch OFF!");
        if (consumers.length != 0){
            for (ElectricityConsumer consumer: consumers) {
                consumer.electricityOff();
            }
        }
    }
}
