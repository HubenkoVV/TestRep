package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    public final ResourceBundle bundleMessages;

    public View(Locale locale){
        bundleMessages = ResourceBundle.getBundle("messages", locale);
    }

    public void printMessageFromBundle(String message){
        System.out.println(bundleMessages.getString(message));
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
