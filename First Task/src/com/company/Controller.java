package com.company;

import java.util.Scanner;

/**
 * Created by Влада on 29.10.2017.
 */
public class Controller {

    //Constants for checking
    private final String HELLO = "Hello";
    private final String WORLD = "world!";

    private Model model;
    private View view;

    /**
     * Constructor
     * @param model object of model with which program works
     * @param view object of view with which program works
     */
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setFirstWord(inputFirstValue(sc));
        model.setSecondWord(inputSecondValue(sc));

        String yourSentence = model.makeFullSentence();

        view.printSomething(view.YOUR_SENTENCE + yourSentence);
    }

    //Method for inputting first value
    private String inputFirstValue (Scanner sc) {
        String firstValue;

        view.printSomething(view.PRINT_HELLO_WORD);
        while(!(firstValue = sc.nextLine()).equals(HELLO)) {
            view.printSomething(view.WRONG_INPUT);
        }
        return firstValue;
    }

    //Method for inputting second value
    private String inputSecondValue (Scanner sc) {
        String secondValue;

        view.printSomething(view.PRINT_WORLD_WORD);
        while(!(secondValue = sc.nextLine()).equals(WORLD)) {
            view.printSomething(view.WRONG_INPUT);
        }
        return secondValue;
    }
}
