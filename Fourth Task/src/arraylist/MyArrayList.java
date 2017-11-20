package arraylist;


import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Влада on 19.11.2017.
 */
public class MyArrayList<T> {

    private T [] array;
    private int lastIndex = 0;

    public MyArrayList(){
        array = (T[])(new Object[0]);
    }

    public MyArrayList(Collection <? extends T> col){
        array = (T[])(new Object[col.size()]);
        int count = 0;
        for(T t: col){
            array[count++] = t;
        }
    }

    public MyArrayList(int capacity){
        array = (T[])(new Object[capacity]);
    }

    private void checkCapacity(int capacity){
        if(capacity > array.length) {
            T[] newArray = (T[])(new Object[(int)(array.length * 1.5) + 1]);
            for(int pos=0; pos<array.length; pos++) {
                newArray[pos] = array[pos];
            }
            this.array = newArray;
        }
    }

    public void add(T obj){
        checkCapacity(lastIndex + 1);
        array[lastIndex] = obj;
        lastIndex++;
    }

    public void add(int index, T t){
        if(index > lastIndex || index < 0)
            throw new IllegalArgumentException("Wrong index");

        T tempCurrent;
        T tempNext;

        checkCapacity(lastIndex+1);
        tempCurrent = array[index];
        array[index] = t;

        for(int pos = index+1; pos <= lastIndex; pos++) {
            tempNext = array[pos];
            array[pos] = tempCurrent;
            tempCurrent = tempNext;
        }

        lastIndex++;
    }

    public void addAll(Collection<? extends T> col){
        for(T element : col) {
            this.add(element);
        }
    }

    public void addAll(int index, Collection<? extends T> col){
        if(index > lastIndex || index < 0)
            throw new IllegalArgumentException("Wrong index");
        for(T element : col) {
            this.add(index, element);
            index++;
        }
    }

    public T get(int index){
        if(index > lastIndex || index < 0)
            throw new IllegalArgumentException("Wrong index");
        return array[index];
    }

    public int indexOf(T obj){
        for(int i = 0; i< lastIndex; i++){
            if(array[i].equals(obj))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object obj){
        int index = -1;
        for(int i = 0; i < lastIndex; i++){
            if(array[i].equals(obj))
                index = i;
        }
        return index;
    }

    public void set(int index, T obj){
        if(index > lastIndex || index < 0)
            throw new IllegalArgumentException("Wrong index");
        array[index] = obj;
    }

    public void sort(Comparator<? super T> comp){
        Arrays.sort(array, comp);
    }

    public MyArrayList<T> subList(int start, int end){
        if(end < start || start >= lastIndex || end >= lastIndex)
            throw new IndexOutOfBoundsException();

        MyArrayList<T> resultArray = new MyArrayList<>(end-start);
        for(int i = start+1; i < end; i++){
            resultArray.add(array[i]);
        }
        return resultArray;
    }

    public int size() {
        return lastIndex;
    }

}
