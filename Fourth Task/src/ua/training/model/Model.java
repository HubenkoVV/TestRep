package ua.training.model;

import arraylist.MyArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Влада on 19.11.2017.
 */
public class Model {
    private MyArrayList<Integer> values;

    public MyArrayList<Integer> getValues() {
        return values;
    }

    public HashMap<Integer, Integer> getCountedValues() {
        return countedValues;
    }

    private HashMap <Integer, Integer> countedValues;

    public Model(int sizeOfArray){
        initializeList(sizeOfArray);
        initializeMap();
    }

    void initializeMap(){
        countedValues = new HashMap<Integer, Integer>(values.size());
        for (int i = 0; i < values.size(); i++){
            Integer value = countedValues.get(values.get(i));
            if(value == null){
                countedValues.put(values.get(i), 1);
            } else {
                countedValues.put(values.get(i), new Integer(value + 1));
            }
        }
    }

    void initializeList(int size){
        Random random = new Random();
        values = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            values.add(new Integer(random.nextInt(10)));
        }
    }

    public Integer[] valuesToArray(){
        Integer[] resultArr = new Integer[values.size()];
        for (int i = 0; i < resultArr.length; i++){
            resultArr[i] = values.get(i);
        }
        return resultArr;
    }
}
