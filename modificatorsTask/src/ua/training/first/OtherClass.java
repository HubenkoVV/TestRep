package ua.training.first;

/**
 * Created by Влада on 05.11.2017.
 */
public class OtherClass {

    Parent mParent;

    OtherClass(){
        mParent = new Parent();

        //ПОМИЛКА
        //mParent.privateField = 0;
        mParent.setPrivateField(0);

        mParent.protectedField =0;
        mParent.defaultField =0;
        mParent.publicField =0;
    }
}
