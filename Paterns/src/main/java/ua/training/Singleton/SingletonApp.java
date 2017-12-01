package ua.training.Singleton;

import java.util.Arrays;

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        //Singleton singleton = new Singleton();
        Thread[] singletons = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            singletons[i] = new Thread(new R());
            singletons[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            singletons[i].join();
        }

        System.out.println(Singleton.count);
    }
}

class R implements Runnable{

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton{
    private static Object synh = new Object();

    private static volatile Singleton instance = null;
    static int count = 0;

    private Singleton(){
        count++;
    }

//    public static Singleton getInstance() {
//        return instance;
//    }

//    public static synchronized Singleton getInstance() {
//        if(instance == null)
//            instance = new Singleton();
//        return instance;
//    }

//        public static Singleton getInstance(){
//        if(instance == null)
//            instance = new Singleton();
//        return instance;
//    }
//

       static Singleton getInstance(){
            if(instance == null)
                synchronized (synh) {
                    if(instance == null)
                        instance = new Singleton();
                }
            return instance;
        }
}