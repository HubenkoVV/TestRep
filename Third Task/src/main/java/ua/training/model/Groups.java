package main.java.ua.training.model;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by Влада on 13.11.2017.
 */
public enum Groups {

    FAMILY(1),
    FRIENDS(2),
    CLASSMATTES(3),
    COLLEAGUES(4);

    private final int number;

    Groups(int number) {
        this.number = number;
    }
    public int number() { return number; }

    public static Groups getByNumber(int number){
        for(Groups v : values()) {
            if(v.number == number) return v;
        }
        return null;
    }


    public static String groups(){
        StringBuilder concatString = new StringBuilder();
        for(Groups v : values()) {
            concatString = concatString.append(v.toString() + " - " + v.number + "\n");
        }
        return new String(concatString);
    }
}
