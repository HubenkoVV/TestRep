package ua.training.Facade;

public class FacadeApp {
    public static void main(String[] args) {
        Coputer facade = new Coputer();
        facade.copy();
    }
}

//Facade
class Coputer{
    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power{
    void on(){
        System.out.println("On power");
    };
    void off(){
        System.out.println("Off power");
    };
}

class DVDRom{
    private boolean data = false;
    public boolean isData() {
        return data;
    }

    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }

}

class HDD{
    void copyFromDVD(DVDRom dvdRom){
        if(dvdRom.isData())
            System.out.println("Copy data from DVD");
        else System.out.println("There is no disk");
    }
}
