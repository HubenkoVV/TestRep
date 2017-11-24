package arraylist;


import java.util.*;

/**
 * Created by Влада on 19.11.2017.
 */
public class MyArrayList<T> extends AbstractList<T>{

    private Object [] array;
    private int DEFAULT_SIZE = 16;
    private int lastIndex = 0;

    public MyArrayList(){
        array = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(Collection <? extends T> col){
        array = new Object[col.size()];
        int count = 0;
        for(T t: col){
            array[count++] = t;
        }
    }

    public MyArrayList(int capacity){
        array = new Object[capacity];
    }

    private void checkCapacity(int capacity){
        if(capacity > array.length) {
            Object[] newArray = new Object[(int)(array.length * 1.5) + 1];
            for(int pos=0; pos<array.length; pos++) {
                newArray[pos] = array[pos];
            }
            this.array = newArray;
        }
    }

    @Override
    public boolean add(T t) {
        checkCapacity(lastIndex + 1);
        array[lastIndex++] = t;
        return true;
    }

    @Override
    public void add(int index, T element){
        if(index > lastIndex || index < 0)
            throw new IllegalArgumentException("Wrong index");

        Object tempCurrent;
        Object tempNext;

        checkCapacity(lastIndex+1);
        tempCurrent = array[index];
        array[index] = element;

        for(int pos = index+1; pos <= lastIndex; pos++) {
            tempNext = array[pos];
            array[pos] = tempCurrent;
            tempCurrent = tempNext;
        }

        lastIndex++;
    }

    @Override
    public T get(int index){
        if(index > lastIndex || index < 0)
            throw new IllegalArgumentException("Wrong index");
        return (T) array[index];
    }

    @Override
    public int size() {
        return lastIndex;
    }

}
