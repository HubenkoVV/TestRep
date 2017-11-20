package ua.training.view;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Влада on 19.11.2017.
 */
public class View {
    private static final String ARRAY = "Your array";
    private static final String MAP = "Map:";

    void printMessage(String message){
        System.out.println(message);
    }

    public <T> void printArray (T[] array){
        printMessage(ARRAY);
        for (T t:array){
            System.out.print(t + " ");
        }
        printMessage("");
    }

    public <T, K> void printMap (Map<T, K> map){
        printMessage(MAP);
        for (Map.Entry<T,K> t: map.entrySet()){
            System.out.println(t.getKey() + " - " + t.getValue());
        }
    }

}
