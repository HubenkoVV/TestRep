package com.company;

/**
 * CHANGES
 * Added methods findIndexesOfNumber(), isNumberFound(), getCount()
 * Created by Влада on 31.10.2017.
 */
public class Model {
    //Array that we work with
    private int [] arr;

    /**
     * Constructor in which we initialize our array by different numbers.
     * ONLY FOR DEMONSTRATION
     */
    Model() {
        arr = new int[]{15, 11, 5, 65, 15, 34, 1, 15, 33, 6};
    }

    public int[] getArr() {
        return arr;
    }

    /**
     * Method in which we find our FOUND_NUMBER
     * @param foundNumber is FOUND_NUMBER from Controller
     * @return number is found or not

     */
    public boolean isNumberFound(int foundNumber)
    {
        boolean result = false;

        int size = arr.length;
        for (int i = 0; i < size; i++){
            if(arr[i] == foundNumber){
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method that notes indexes of number that we want to find
     * @param foundNumber is FOUND_NUMBER from Controller
     * @return array of all found indexes of FOUND_NUMBER
     */
    public int[] findIndexesOfNumber(int foundNumber)
    {
        int [] arrayOfIndexes = new int[getCount(foundNumber)];
        int index = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++){
            if(arr[i] == foundNumber){
                arrayOfIndexes[index++] = i;
            }
        }
        return arrayOfIndexes;
    }

    /**
     * Method calculates amount of foundNumbers in arr
     * @param foundNumber foundNumber is FOUND_NUMBER from Controller
     * @return amount of foundNumbers
     */
    private int getCount(int foundNumber){
        int count = 0;

        int size = arr.length;
        for (int i = 0; i < size; i++){
            if(arr[i] == foundNumber){
                count++;
            }
        }
        return count;
    }



}
