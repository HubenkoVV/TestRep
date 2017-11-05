package ua.training.second;

import ua.training.first.Parent;

/**
 * Created by Влада on 05.11.2017.
 */
public class SecondChild extends Parent {

    SecondChild(){
        //ПОМИЛКА
        //privateField = 0;
        super.setPrivateField(0);

        protectedField = 0;

        //ПОМИЛКА
        //defaultField = 0;
        super.setDefaultField(0);

        publicField = 0;
    }
}
