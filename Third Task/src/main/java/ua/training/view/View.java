package main.java.ua.training.view;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
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

    public void printMessageFromBundle(String message){
        System.out.println(bundleMessages.getString(message));
    }

    public void printMessage(String message){
        System.out.println(message);
    }

}
