package com.company;

/**
 * Created by Влада on 31.10.2017.
 */
public class View {

    //Text`s constants
    public static final String ARRAY = "Our array: ";
    public static final String INDEXES = "Indexes of looked for number : ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printIntArray(int[]arr){
        for (int element: arr) {
            System.out.print(element + " ");
        }
    }
}
