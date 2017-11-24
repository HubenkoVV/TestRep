package ua.training.controller;

import ua.training.model.Model;
import ua.training.view.View;

/**
 * Created by Влада on 19.11.2017.
 */
public class Controller {
    private final int SIZE_OF_ARRAY = 13;
    private Model model;
    private View view;

    public Controller() {
        model = new Model(13);
        view = new View();
    }

    public void processUser(){
        view.printArray(model.getValues().toArray());
        view.printMap(model.getCountedValues());
    }
}
