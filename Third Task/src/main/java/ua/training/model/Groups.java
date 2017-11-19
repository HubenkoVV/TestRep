package main.java.ua.training.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Влада on 13.11.2017.
 */
public enum Groups {

    FAMILY(1),
    FRIENDS(2),
    CLASSMATES(3),
    COLLEAGUES(4);

    private final int number;

    Groups(int number) {
        this.number = number;
    }
    public int number() { return number; }

    public static ArrayList getEnum() {
        ArrayList<String> values = new ArrayList<>();
        for(Groups v : values()) {
            values.add(v.name() + " " + v.number);
        }
        return values;
    }
}
