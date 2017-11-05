package ua.training.first;

/**
 * Created by Влада on 05.11.2017.
 */
public class Parent {

    private int privateField;
    protected double protectedField;
    int defaultField;
    public int publicField;

    public double getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(double secondField) {
        this.protectedField = secondField;
    }

    public int getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(int thirdField) {
        this.defaultField = thirdField;
    }

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int firstField) {
        this.privateField = firstField;
    }


}
