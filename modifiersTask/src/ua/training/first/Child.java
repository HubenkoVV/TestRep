package ua.training.first;

/**
 * Created by Влада on 05.11.2017.
 */
public class Child extends Parent {
    Child(){
        //ПОМИЛКА
        //privateField = 0;
        super.setPrivateField(0);

        protectedField = 0;
        defaultField = 0;
        publicField = 0;
    }

}
