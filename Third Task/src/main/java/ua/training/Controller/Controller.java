package main.java.ua.training.Controller;

import main.java.ua.training.model.Note;
import main.java.ua.training.model.Notebook;
import main.java.ua.training.view.View;

import java.util.Scanner;

import static main.java.ua.training.view.Constants.*;

/**
 * Class that consists methods only with description inputting values without user`s inputting
 *
 * Created by Влада on 13.11.2017.
 */
public class Controller {

    /**
     * Object of user`s notebook
     */
    private Notebook notebook;
    private View view;
    private Scanner sc;

    /**
     *
     * @param view current view
     * @param notebook current user`s notebook
     */
    public Controller(View view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
        sc = new Scanner(System.in);
    }

    /**
     * The main process method
     */
    public void processUser(){
        InputNotebook inputNotebook = new InputNotebook(view, notebook);
        view.printMessageFromBundle(CHOOSE);
        while (sc.nextInt() != 0) {
            inputNotebook.inputData();
            view.printMessageFromBundle(ADDING);
            view.printMessageFromBundle(CHOOSE);
        }

        view.printList(notebook.getNotebook());

    }





}
