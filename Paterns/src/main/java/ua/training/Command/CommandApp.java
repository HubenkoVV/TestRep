package ua.training.Command;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User u = new User(new StartCommand(comp),new StopCommand(comp), new ResetCommand(comp));
        u.startComp();
        u.stopComp();
        u.resetComp();
    }
}

class User{
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComp(){
        start.execute();
    }
    void stopComp(){
        stop.execute();
    }
    void resetComp(){
        reset.execute();
    }
}

interface Command{
    void execute();
}

class Comp{
    void start(){
        System.out.println("Start");
    };
    void stop(){
        System.out.println("Stop");
    };
    void reset(){
        System.out.println("Reset");
    };
}

class StartCommand implements Command{
    Comp computer;
    public StartCommand(Comp comp){
        computer = comp;
    }

    public void execute() {
        computer.start();
    }
}

class StopCommand implements Command{
    Comp computer;
    public StopCommand(Comp comp){
        computer = comp;
    }

    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Command{
    Comp computer;
    public ResetCommand(Comp comp){
        computer = comp;
    }

    public void execute() {
        computer.reset();
    }
}