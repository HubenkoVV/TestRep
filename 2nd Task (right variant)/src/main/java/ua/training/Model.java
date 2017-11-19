package main.java.ua.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Влада on 03.11.2017.
 */
public class Model {

    /**
     * Secret value
     */
    private int thoughtNumber;
    // Only for tests
    public int getThoughtNumber() {
        return thoughtNumber;
    }
    /**
     * Values of interval
     */
    private int maxValue;
    private int minValue;
    /**
     * List of steps
     */
    private ArrayList<Integer> yourWay;
    private int numbetOfTryings;

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public ArrayList<Integer> getYourWay() {
        return yourWay;
    }

    public int getNumbetOfTryings() {
        return numbetOfTryings;
    }

    public Model(){
        yourWay = new ArrayList<Integer>();
        minValue = 0;
        maxValue = 0;
        numbetOfTryings = 0;
    }

    public void makeInterval(int min, int max){
        minValue = min;
        maxValue = max;
    }

    public void rand() {
        thoughtNumber = new Random().nextInt(maxValue - minValue + 1) + minValue;
    }

    public int isInputEqualsThoughtNumber(int input){
        int result = 0;

        if(!isValueInInterval(input)) {
            result = 2;
        } else {
            result = Integer.compare(thoughtNumber, input);
            changeInterval(result,input);
        }

        yourWay.add(input);
        numbetOfTryings++;
        return result;
    }

    public boolean isValueInInterval(int value) {
        boolean result = true;
        if(value < minValue || value > maxValue){
            result = false;
        }
        return result;
    }

    private void changeInterval(int equal, int value) {
        switch (equal){
            case 1:
                minValue = value;
                break;
            case -1:
                maxValue = value;
                break;
        }
    }

}
