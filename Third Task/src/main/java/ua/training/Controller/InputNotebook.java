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
 * Class where is written methods with user`s inputting data
 *
 * Created by Влада on 13.11.2017.
 */
public class InputNotebook {

    private View view;
    private Notebook notebook;

    public InputNotebook(View view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
    }

    /**
     * Adding new note to the notebook
     * Writing inputted data in this note
     */
    void inputData() {
            UtilityController utilityController = new UtilityController(view);
        Note note = new Note();
            note.setLogin(utilityController.inputLogin(notebook,LOGIN));
            note.setName(utilityController.inputData(INPUT_NAME, NAME_REG));
            note.setNumber(utilityController.inputData(INPUT_TELEPHONE, PHONE));
            note.setGroup(utilityController.chooseGroup());
            notebook.addingNote(note);
    }
}
