package com.company;

import java.util.Random;

/**
 * Created by Влада on 01.11.2017.
 */
public class Model {

    private int thoughtNumber;
    public final int RAND_MAX = 100;
    public int maxValue;
    public int minValue;

    /**
     * Method that makes number in automatic interval
     */
    public void rand() {
        Random random = new Random();
        thoughtNumber = random.nextInt(RAND_MAX + 1);
        minValue = 0;
        maxValue = RAND_MAX;
    }

    /**
     * Method that makes number in user`s interval
     * @param min
     * @param max
     */
    public void rand(int min, int max) {
        minValue = min;
        maxValue = max;
        Random random = new Random();
        thoughtNumber = random.nextInt(max - min + 1) + min;
    }

    public int isInputEqualsNumber(int input){
        int result = 0;

        if(!isValueInInterval(input)) {
            result = 2;
        } else {
            result = Integer.compare(thoughtNumber, input);
            changeInterval(result,input);
        }
        return result;
    }

    private boolean isValueInInterval(int value) {
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
