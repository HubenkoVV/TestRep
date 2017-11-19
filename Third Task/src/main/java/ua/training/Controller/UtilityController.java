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
 * Created by Влада on 13.11.2017.
 */
public class UtilityController {
    private Scanner sc;
    private View view;
    private Locale locale;
    private ResourceBundle bundle;

    public UtilityController(Scanner sc, View view) {
        this.sc = sc;
        this.view = view;
        this.locale = view.getLocale();
        bundle = ResourceBundle.getBundle("regex", locale);
    }

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
        view.printMessage(Groups.groups());
        while( !(sc.hasNext() && (result = sc.nextInt())<= Groups.values().length)) {
            view.printMessageFromBundle(WRONG_VALUE);
        }
        return Groups.getByNumber(result);
    }
}
