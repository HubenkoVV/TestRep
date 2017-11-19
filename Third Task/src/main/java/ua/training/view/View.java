package main.java.ua.training.view;

import main.java.ua.training.model.Groups;
import main.java.ua.training.model.Note;
import main.java.ua.training.model.Notebook;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static main.java.ua.training.view.Constants.NOTEBOOK;

/**
 * Class that works with visual presentment
 *
 * Created by Влада on 13.11.2017.
 */
public class View {

    public final ResourceBundle bundleMessages;
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public View(Locale locale){
        this.locale = locale;
        bundleMessages = ResourceBundle.getBundle("messages", locale);
    }

    /**
     * print messages from Resource Bundle "messages"
     * @param message
     */
    public void printMessageFromBundle(String message){
        System.out.println(bundleMessages.getString(message));
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printList(ArrayList list){
        for (Object ob : list) {
            printMessage(ob.toString());
        }
    }

}
