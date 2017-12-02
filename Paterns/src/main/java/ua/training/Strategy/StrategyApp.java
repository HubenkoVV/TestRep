package ua.training.Strategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {

        StrategyClient strategyClient = new StrategyClient();

        int[] arr = {1,5,2,6,7,8,3,6};
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(arr);

        int[] arr1 = {1,5,4,2,6,8,1,6};
        strategyClient.setStrategy(new InsertSort());
        strategyClient.executeStrategy(arr1);

        int[] arr2 = {1,5,7,2,6,4,3,6};
        strategyClient.setStrategy(new SelectionSort());
        strategyClient.executeStrategy(arr2);
    }
}

class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    void executeStrategy(int [] array){
        strategy.sort(array);
    }
}

//Strategy
interface Sorting{
    void sort(int [] array);
}

//Only for demonstration
//So there are not realizations of sortings here

class BubbleSort implements Sorting{
    @Override
    public void sort(int[] array) {
        System.out.println("Bubble sort");
        System.out.println("Before: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("After: " + Arrays.toString(array));
    }
}

class InsertSort implements Sorting{
    @Override
    public void sort(int[] array) {
        System.out.println("Insert sort");
        System.out.println("Before: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("After: " + Arrays.toString(array));
    }
}

class SelectionSort implements Sorting{
    @Override
    public void sort(int[] array) {
        System.out.println("Selection sort");
        System.out.println("Before: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("After: " + Arrays.toString(array));
    }
}
