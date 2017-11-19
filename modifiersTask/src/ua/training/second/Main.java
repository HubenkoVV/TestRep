package ua.training.second;

import ua.training.first.Child;
import ua.training.first.Parent;
import ua.training.second.SecondChild;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parent parent = new Parent();

        //ПОМИЛКА
        //parent.privateField = 0;
        parent.setPrivateField(0);

        //ПОМИЛКА
        //parent.protectedField = 0;
        parent.setProtectedField(0);

        //ПОМИЛКА
        //parent.defaultField = 0;
        parent.setDefaultField(0);

        parent.publicField = 0;
    }
}
