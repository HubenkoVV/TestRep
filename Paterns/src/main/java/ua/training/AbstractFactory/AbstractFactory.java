package ua.training.AbstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = deviceFactory("ENG");
        Mouse m = deviceFactory.getMouse();
        Keyboard k = deviceFactory.getKeyboard();
        TouchPad t = deviceFactory.getTouchPad();

        m.click();
        k.print();
        t.track(3,5);

    }

    static DeviceFactory deviceFactory(String country){
        if(country.equals("RUS"))
            return new DeviceFactoryRus();
        else return new DevicefactoryEng();
    }
}

interface Mouse{
    void click();
    void dblclick();
    void scroll(int direction);
}
interface TouchPad{
    void track(int deltaX, int deltaY);
}
interface Keyboard{
    void print();
    void prontln();
}

class MouseRus implements Mouse{
    public void click(){
        System.out.println("Клик");
    };
    public void dblclick(){
        System.out.println("Двойной клик");
    };
    public void scroll(int direction){
        if(direction == 0)
            System.out.println("Вверх");
        else System.out.println("Вниз");
    };
}
class TouchPadRus implements TouchPad{
    public void track(int deltaX, int deltaY){
        int i = (int)Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + i + " пикселей");
    };
}
class KeyboardRus implements Keyboard{
    public void print(){
        System.out.println("Печать");
    };
    public void prontln(){
        System.out.println("Печать с новой строки");
    };
}

class MouseEng implements Mouse{
    public void click(){
        System.out.println("Click");
    };
    public void dblclick(){
        System.out.println("Double click");
    };
    public void scroll(int direction){
        if(direction == 0)
            System.out.println("Up");
        else System.out.println("Down");
    };
}
class TouchPadEng implements TouchPad{
    public void track(int deltaX, int deltaY){
        int i = (int)Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2));
        System.out.println("Replaced on " + i + " pixels");
    };
}
class KeyboardEng implements Keyboard{
    public void print(){
        System.out.println("Print");
    };
    public void prontln(){
        System.out.println("Print with new line");
    };
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    TouchPad getTouchPad();
}
class DeviceFactoryRus implements DeviceFactory{
    public Mouse getMouse(){
        return new MouseRus();
    };
    public Keyboard getKeyboard(){
        return new KeyboardRus();
    };
    public TouchPad getTouchPad(){
        return new TouchPadRus();
    };
}
class DevicefactoryEng implements DeviceFactory{
    public Mouse getMouse(){
        return new MouseEng();
    };
    public Keyboard getKeyboard(){
        return new KeyboardEng();
    };
    public TouchPad getTouchPad(){
        return new TouchPadEng();
    };
}