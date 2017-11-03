package com.company;

/**
 * Created by Влада on 01.11.2017.
 */
public class View {
    // Constants for showwing information
    public static final String START = "Let`s play;)";
    public static final String INPUT_INTERVAL = "Do you want to input [min;max]? (Yes/No)";
    public static final String INPUT_MIN_VALUE = "Input minimum value";
    public static final String INPUT_MAX_VALUE = "Input maximum value";
    public static final String GUESS_NUMBER = "Try to guess number ;)";
    public static final String NUMBER_IS_LESS_TEXT = "Number is less than input value";
    public static final String NUMBER_IS_MORE_TEXT = "Number is more than input value";
    public static final String WRONG_VALUE = "Wrong value. Please, try again";
    public static final String FINAL = "Congratulations! You guessed number :)";
    public static final String NUMBER_NOT_FROM_INTERVAL = "Value isn`t from interval :)";
    public static final String STATISTIC = "Number of tryings = ";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
