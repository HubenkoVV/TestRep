package main.java.ua.training.Controller;

import main.java.ua.training.model.Groups;
import main.java.ua.training.model.LoginAlreadyExists;
import main.java.ua.training.model.Note;
import main.java.ua.training.model.Notebook;
import main.java.ua.training.view.View;
import java.util.Scanner;

import static main.java.ua.training.Controller.RegexSource.*;
import static main.java.ua.training.view.Constants.*;

/**
 * Created by Влада on 13.11.2017.
 */
public class InputNotebook {

    private Scanner sc;
    private Note mNote;
    private View view;
    private Notebook notebook;

    public InputNotebook(Scanner sc, View view, Notebook notebook) {
        this.sc = sc;
        this.view = view;
        this.notebook = notebook;
    }

    void inputData() {
            UtilityController utilityController = new UtilityController(sc, view);
            mNote = new Note();
            mNote.setLogin(utilityController.inputLogin(notebook,LOGIN));
            mNote.setName(utilityController.inputData(INPUT_NAME, NAME_REG));
            mNote.setNumber(utilityController.inputData(INPUT_TELEPHONE, PHONE));
            mNote.setGroup(utilityController.chooseGroup());
            notebook.addingNote(mNote);
    }
}
