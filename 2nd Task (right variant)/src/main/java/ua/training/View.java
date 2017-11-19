package main.java.ua.training;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Влада on 03.11.2017.
 */
public class View {
    //ResourceBundle constants
    private static final String BUNDLE_NAME = "messagesm";
    private static final ResourceBundle bundle = ResourceBundle.getBundle( BUNDLE_NAME, new Locale("ua", "UA"));  // Ukrainian
            //new Locale("en", "EN"));

    //Symbol constants
    private static final String SPACE_SING = " ";
    private static final String OPENS_SQUARE_BRACKET = "[";
    private static final String CLOSING_SQUARE_BRACKET = "]";

    //Text constants
    private static final String START = "start";
    private static final String INPUT_INTERVAL = "input.interval";
    private static final String INPUT_MIN_VALUE = "input.min.value";
    private static final String INPUT_MAX_VALUE = "input.max.value";
    private static final String GUESS_NUMBER = "guess.number";
    private static final String WRONG_NUMBER = "wrong.number";
    private static final String FINAL = "final";
    private static final String WRONG_RANGE = "wrong.range";
    private static final String STATISTIC = "statistic";
    private static final String YOUR_WAY = "way";
    private static final String INTERVAL = "interval";


    //All methods for showing information
    private void printMessage(String message) {
        System.out.println(message);
    }

    void printInterval(int min, int max){
        printMessage(bundle.getString(INTERVAL) + SPACE_SING + OPENS_SQUARE_BRACKET + min + ";" + max + CLOSING_SQUARE_BRACKET);
    }

    void printWay(List<Integer> yourWay){
        printMessage(bundle.getString(YOUR_WAY) + SPACE_SING + yourWay.toString());
    }

    void printStatictic(int numberOfTryings){
        printMessage(bundle.getString(STATISTIC) + SPACE_SING + numberOfTryings);
    }

    void printWrongValue(){
        printMessage(bundle.getString(WRONG_NUMBER));
    }

    void printWrongRange(){
        printMessage(bundle.getString(WRONG_RANGE));
    }

    void printFinal(){
        printMessage(bundle.getString(FINAL));
    }

    void printInputMin(){
        printMessage(bundle.getString(INPUT_MIN_VALUE));
    }

    void printInputMax(){
        printMessage(bundle.getString(INPUT_MAX_VALUE));
    }

    void printStart(){
        printMessage(bundle.getString(START));
    }

    void printGuess(){
        printMessage(bundle.getString(GUESS_NUMBER));
    }

    void printInputInterval(){
        printMessage(bundle.getString(INPUT_INTERVAL));
    }

}
