package controller;

import services.*;
import view.View;

import java.util.Locale;
import java.util.Scanner;

import static view.ViewConstants.*;

public class UserController {

    private Scanner scanner = new Scanner(System.in);
    private View view;
    private CommandTest commandPassTest;
    private CommandTest commandCreateTest;

    public UserController() throws ClassNotFoundException {
        String language = chooseCountry();
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory(language);
        view = new View(new Locale(language));
        Test test = new Test(jdbcDaoFactory,view,scanner);
        commandPassTest = new CommandPassTest(test);
        commandCreateTest = new CommandCreateTest(test);
    }

    private String chooseCountry(){
        System.out.println("Choose country: \n\t1.Ukraine \n\t2.England");
        int choose = inputInt();
        if(choose == 1)
            return "uk";
        return "en";
    }

    public void userAction(){
        int choose = 0;
        while (choose != 3) {
            view.printMessageFromBundle(CHOOSE_ACT);
            choose = inputInt();
            if (choose == 1)
                commandCreateTest.execute();
            else  if(choose == 2)
                commandPassTest.execute();
            else if(choose != 3)view.printMessageFromBundle(WRONG);
        }
    }

    private int inputInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (IllegalArgumentException ex) {
                view.printMessageFromBundle(WRONG);
            }
        }
    }


}
