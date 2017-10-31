package com.company;

/**
 * CHANGES
 *
 * Created by Влада on 31.10.2017.
 */
public class Controller {
    //Constant for number which we want to find
    public static final int FOUND_NUMBER = 15;

    Model model;
    View view;

    /**
     * Constructor
     * @param model
     * @param view
     */
    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    /**
     * The Work Method
     */
    public void processUser()
    {
        view.printMessage(view.ARRAY);
        view.printIntArray(model.getArr());
        if(model.isNumberFound(FOUND_NUMBER)) {
            view.printMessage("\n" + view.INDEXES);
            int[] arrayOfIndexes = model.findIndexesOfNumber(FOUND_NUMBER);
            view.printIntArray(arrayOfIndexes);
        }

    }



}
