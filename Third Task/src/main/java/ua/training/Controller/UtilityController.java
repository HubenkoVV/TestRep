package main.java.ua.training.Controller;

import main.java.ua.training.model.LoginAlreadyExists;
import main.java.ua.training.model.Notebook;
import main.java.ua.training.view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static main.java.ua.training.view.Constants.CHOOSE_GROUP;
import static main.java.ua.training.view.Constants.INPUT_LOGIN;
import static main.java.ua.training.view.Constants.WRONG_VALUE;
import main.java.ua.training.model.Groups;


/**
 * Controller that works with console input
 *
 * Created by Влада on 13.11.2017.
 */
public class UtilityController {
    private Scanner sc = new Scanner(System.in);
    private View view;
    private ResourceBundle bundle;

    public UtilityController(View view) {
        this.view = view;
        Locale locale = view.getLocale();
        bundle = ResourceBundle.getBundle("regex", locale);
    }

    /**
     *
     * @param message message about data in note that user must write(except login and group)
     * @param regex statment with format of inputting data
     * @return data
     */
    public String inputData(String message, String regex){
        String result;
        view.printMessageFromBundle(message);
        view.printMessage(bundle.getString(regex));
        while( !(sc.hasNext() && (result = sc.next()).matches(bundle.getString(regex)))) {
            view.printMessageFromBundle(WRONG_VALUE);
        }
        return result;
    }

    public String inputLogin (Notebook notebook, String regex){
        String login = "";
        do {
            try {
                login = inputData(INPUT_LOGIN, regex);
                if (notebook.isLoginAlreadyExists(login))
                    throw new LoginAlreadyExists("Login is not unique: ", login);
            } catch (LoginAlreadyExists ex) {
                view.printMessage(ex.getMessage() + ex.getLogin());
                login = "";
            }
        } while (login == "");
        return login;
    }

    public Groups chooseGroup(){
        int result;
        view.printMessageFromBundle(CHOOSE_GROUP);
        view.printList(Groups.getEnum());
        while( !(sc.hasNext() && (result = sc.nextInt())<= Groups.values().length)) {
            view.printMessageFromBundle(WRONG_VALUE);
        }
        return Groups.values()[result];
    }
}
