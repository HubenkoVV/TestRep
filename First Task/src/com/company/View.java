package com.company;

/**
 * Class that works with information for showing it for user
 * Created by Влада on 29.10.2017.
 */
public class View {

    //Text`s constants
    public static final String PRINT_HELLO_WORD = "Print \"Hello\": ";
    public static final String PRINT_WORLD_WORD = "Print \"world!\": ";
    public static final String WRONG_INPUT = "Wrong input! Repeat please! ";
    public static final String YOUR_SENTENCE = "Your sentence = ";

    public void printSomething(String message){
        System.out.println(message);
    }
}
