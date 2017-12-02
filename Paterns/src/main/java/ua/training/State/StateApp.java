package ua.training.State;

public class StateApp {
    public static void main(String[] args){

        //SECOND EXAMPLE
        Human human = new Human();
        human.setState(new WeekEnd());
        int i = 0;
        while (i < 10) {
            human.doSmth();
            i++;
        }


        //FIRST EXAMPLE
//        Station station = new Radio7();
//        Radio radio = new Radio();
//        radio.setStation(station);
//
//        int i = 0;
//        while (i < 10) {
//            radio.nextStation();
//            radio.play();
//            i++;
//        }
    }
}

//SECOND EXAMPLE
//State changed in ConcreteState
class Human{
    private Activity state;

    void setState(Activity state) {
        this.state = state;
    }

    public void doSmth(){
        state.doSmth(this);
    }
}

interface Activity{
    void doSmth(Human context);
}

class Work implements Activity{

    @Override
    public void doSmth(Human context) {
        System.out.println("Working");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity{
    private int count = 0;

    @Override
    public void doSmth(Human context) {
        if(count < 3) {
            System.out.println("Weekends");
            count++;
        }
        else {
            context.setState(new Work());
        }
    }
}

//FIRST EXAMPLE
//State changed in Context
//State
interface Station{
    void play();
}

class Radio7 implements Station{
    @Override
    public void play() {
        System.out.println("Radio 7");
    }
}

class DFM implements Station{
    @Override
    public void play() {
        System.out.println("DFM");
    }
}

class Vesti implements Station{
    @Override
    public void play() {
        System.out.println("Vesti");
    }
}
//Context
class Radio{
    private Station station;

    void setStation(Station station) {
        this.station = station;
    }

    void nextStation(){
        if(station instanceof Radio7)
            setStation(new DFM());
        else if(station instanceof DFM)
            setStation(new Vesti());
        else if(station instanceof Vesti)
            setStation(new Radio7());
    }

    void play(){
        station.play();
    }
}