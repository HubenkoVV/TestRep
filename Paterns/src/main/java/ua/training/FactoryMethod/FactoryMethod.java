package ua.training.FactoryMethod;

import java.util.Date;

/**
 * Hello world!
 */
public class FactoryMethod {
    public static void main(String[] args) {
        String maker = "digital"; //"rome";
        Creator creator = makeCreator(maker);
        Watch watch = creator.createWatch();
        watch.showTime();

    }

    static Creator makeCreator(String maker) {
        if(maker.equals("digital"))return new CreatorDigitalWatch();
        if(maker.equals("rome"))
            return new CreatorRomeWatch();
        else new RuntimeException("Unsupported type of watch");
        return null;
    }
}

interface Creator {
    Watch createWatch();
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VIII V");
    }
}

class CreatorDigitalWatch implements Creator {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class CreatorRomeWatch implements Creator {
   public Watch createWatch() {
        return new RomeWatch();
    }
}