package ua.training;

import java.util.Scanner;

/**
 * Created by Влада on 03.11.2017.
 */
public class Controller {
    //Constants
    private final String YES = "Yes";
    private final String NO = "NO";
    private final int NUMBER_IS_GUESSED = 0;
    private final int NUMBER_IS_NOT_FROM_INTERVAL = 2;
    private final int RAND_MAX = 100;

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);

        view.printStart();
        chooseInterval(sc);
        model.rand();
        guessValue(sc);
        view.printStatictic(model.getNumbetOfTryings());
        view.printWay(model.getYourWay());
    }

    /**
     * Choosing interval of numbers
     * Variant 1 - automatic [0; RAND_MAX]
     * Variant 2 - user`s [min; max]
     * @param sc
     */
    private void chooseInterval(Scanner sc){
        while (true) {
            view.printInputInterval();
            String agree = sc.nextLine();
            if (agree.equalsIgnoreCase(YES)) {
                makeUserInterval(sc);
                break;
            } else if (agree.equalsIgnoreCase(NO)) {
                model.makeInterval(0,RAND_MAX);
                break;
            } else {
                view.printWrongValue();
            }
        }
    }

    private void makeUserInterval(Scanner sc) {
        int min, max;
        while (true) {
            view.printInputMin();
            min = inputIntValue(sc);
            view.printInputMax();
            max = inputIntValue(sc);
            if(max > min){
                break;
            } else {
                view.printWrongValue();
            }
        }
        model.makeInterval(min, max);
    }

    /**
     * The main method for game
     */
    private void guessValue(Scanner sc) {
        int equal = 2;
        int value;
        view.printGuess();

        while (equal != 0) {
            view.printInterval(model.getMinValue(),model.getMaxValue());
            value = inputIntValue(sc);
            equal = model.isInputEqualsThoughtNumber(value);
            printResultOfComparing(equal);
        }
    }

    private void printResultOfComparing(int equal) {
        switch (equal){
            case NUMBER_IS_GUESSED:
                view.printFinal();
                break;
            case NUMBER_IS_NOT_FROM_INTERVAL:
                view.printWrongRange();
                break;
        }
    }

    //Method for inputting int values
    private int inputIntValue(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printWrongValue();
            sc.next();
        }
        return sc.nextInt();
    }

}
