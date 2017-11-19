package main.java.ua.training;

import main.java.ua.training.Controller.Controller;
import main.java.ua.training.model.Notebook;
import main.java.ua.training.view.View;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Locale locale = new Locale("uk");
        //Locale locale = new Locale("en");

        Controller controller = new Controller(new View(locale), new Notebook());
        controller.processUser();
    }
}
