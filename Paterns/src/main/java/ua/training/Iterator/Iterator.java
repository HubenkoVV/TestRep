package ua.training.Iterator;

public class Iterator {
    public static void main(String[] args) {
        Tasks ca = new Tasks();
        IteratorInterface it = ca.getIterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

interface IteratorInterface{
    boolean hasNext();
    Object next();
}

interface Conteiner{
    IteratorInterface getIterator();
}

class Tasks implements Conteiner{
    String[] tasks = {"Write message", "Send message", "Read message"};

    public IteratorInterface getIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements IteratorInterface{
        int index = 0;

        public boolean hasNext() {
            if(index < tasks.length)
                return true;
            return false;
        }

        public Object next() {
            return tasks[index++];
        }
    }
}
