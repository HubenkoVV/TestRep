package ua.training.Chain;

public class ChainApp {
    public static void main(String[] args) {
        Logger sms = new SMSLogger(Level.ERROR);
        Logger file = new FileLogger(Level.DEBUG);
        Logger mail = new MailLogger(Level.INFO);
        sms.setNext(file);
        file.setNext(mail);

        sms.writeMessage("KEK",Level.INFO);
        sms.writeMessage("WTF", Level.ERROR);
        sms.writeMessage("WOW", Level.DEBUG);
    }
}

class Level{
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;
}

abstract class Logger{
    private int priority;
    private Logger next;

    Logger(int priority) {
        this.priority = priority;
    }

    void setNext(Logger next) {
        this.next = next;
    }

    void writeMessage(String message, int level){
        if (level <= priority){
            write(message);
        }
        if(next != null){
            next.writeMessage(message,level);
        }
    };

    abstract void write(String message);
}

class SMSLogger extends Logger{
    SMSLogger(int priority) {
        super(priority);
    }
    void write(String message){
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger{
    FileLogger(int priority) {
        super(priority);
    }
    void write(String message){
        System.out.println("Write into file: " + message);
    }
}

class MailLogger extends Logger{
    MailLogger(int priority)  {
        super(priority);
    }
    void write(String message){
        System.out.println("Mail: " + message);
    }
}