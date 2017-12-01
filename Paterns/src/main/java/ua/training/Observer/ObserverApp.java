package ua.training.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ObserverApp {
    public static void main(String[] args) {
        Meteostation station = new Meteostation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setParameters(4,5);
        station.setParameters(62,234);
    }
}

interface Observered{
    void addObserver(MyObserver o);
    void removeObserver(MyObserver o);
    void notifyObserver();
}

class Meteostation implements Observered{
    int temperature;
    int pressure;
    List<MyObserver> observereds = new ArrayList<>();

    public void setParameters(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObserver();
    }

    public void addObserver(MyObserver o) {
        observereds.add(o);
    }
    public void removeObserver(MyObserver o) {
        observereds.remove(o);
    }
    public void notifyObserver() {
        observereds.forEach(observered -> observered.handleEvent(temperature, pressure));
    }
}

interface MyObserver{
    void handleEvent(int temp, int present);
}

class ConsoleObserver implements MyObserver{

    public void handleEvent(int temp, int present) {
        System.out.println("Temperature = " + temp + " pressure = " + present);
    }
}

class FileObserver implements MyObserver{

    public void handleEvent(int temp, int present) {
        System.out.println("Information was written into the file");
    }
}
