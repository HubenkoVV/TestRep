package main.java.ua.training.Controller;

import main.java.ua.training.model.Note;
import main.java.ua.training.model.Notebook;
import main.java.ua.training.view.View;

import java.util.Scanner;

import static main.java.ua.training.view.Constants.*;

/**
 * Created by Влада on 13.11.2017.
 */
public class Controller {
    private Notebook notebook;
    private Note mNote;
    private View view;
    private Scanner sc;

    public Controller(View view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
        sc = new Scanner(System.in);
    }

    public void processUser(){
        InputNotebook inputNotebook = new InputNotebook(sc, view, notebook);
        int choose = 0;
        view.printMessageFromBundle(CHOOSE);
        while ((choose = sc.nextInt()) != 0) {
            inputNotebook.inputData();
            view.printMessageFromBundle(ADDING);
            view.printMessageFromBundle(CHOOSE);
        }

        printNotebook();

    }

    private void printNotebook(){
        view.printMessage(NOTEBOOK);
        for (Note n: notebook.getNotebook()) {
            view.printMessage(n.toString());
        }
    }



}
