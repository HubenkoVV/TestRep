package com.company;

import java.util.Scanner;

/**
 * Created by ����� on 01.11.2017.
 */
public class Controller {

    private final String YES = "Yes";
    private final String NO = "NO";
    private final int NUMBER_IS_LESS = -1;
    private final int NUMBER_IS_MORE = 1;
    private final int NUMBER_IS_GUESSED = 0;
    private final int NUMBER_IS_NOT_FROM_INTERVAL = 2;


    private Model model;
    private View view;
    private int numberOfTrying;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        numberOfTrying = 0;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);

        view.printMessage(view.START);
        chooseInterval(sc);
        guessValue(sc);

    }

    /**
     * Choosing interval of numbers
     * Variant 1 - automatic
     * Variant 2 - user`s
     * @param sc
     */
    private void chooseInterval(Scanner sc){
        while (true) {
            view.printMessage(view.INPUT_INTERVAL);
            String agree = sc.nextLine();
            if (agree.equalsIgnoreCase(YES)) {
                inputMinMax(sc);
                break;
            } else if (agree.equalsIgnoreCase(NO)) {
                model.rand();
                break;
            } else {
                view.printMessage(view.WRONG_VALUE);
            }
        }
    }

    private void inputMinMax(Scanner sc) {
        view.printMessage(view.INPUT_MIN_VALUE);
        int min = inputIntValue(sc);
        view.printMessage(view.INPUT_MAX_VALUE);
        int max = inputIntValue(sc);
        model.rand(min, max);
    }

    /**
     * The main method for game
     */
    private void guessValue(Scanner sc) {
        int equal = 2;
        int value;

        do {
            view.printMessage("Interval is ["+ model.minValue +";" + model.maxValue + "]");
            view.printMessage(view.GUESS_NUMBER);
            value = inputIntValue(sc);
            equal = model.isInputEqualsNumber(value);
            printResult(equal);
            numberOfTrying++;

        } while (equal != 0);

        view.printMessage(view.STATISTIC + numberOfTrying);
    }

    private void printResult(int equal) {
        switch (equal){
            case NUMBER_IS_MORE:
                view.printMessage(view.NUMBER_IS_MORE_TEXT);
                break;
            case NUMBER_IS_LESS:
                view.printMessage(view.NUMBER_IS_LESS_TEXT);
                break;
            case NUMBER_IS_GUESSED:
                view.printMessage(view.FINAL);
                break;
            case NUMBER_IS_NOT_FROM_INTERVAL:
                view.printMessage(view.NUMBER_NOT_FROM_INTERVAL);
                break;
            default:
                view.printMessage("ERROR");
        }
    }

    //Method for inputting int values
    private int inputIntValue(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_VALUE);
            sc.next();
        }
        return sc.nextInt();
    }
}
