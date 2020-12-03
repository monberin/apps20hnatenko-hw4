package ua.edu.ucu.immutable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue implements Iterable<String> {
    private ImmutableLinkedList lst = new ImmutableLinkedList();
    public Queue(){
    }
    public Object peek() {
        if (this.lst.isEmpty()) {
            return null;
        }
        return this.lst.getFirst();

    } //- Returns the object at the beginning of the ua.edu.ucu.immutable.Queue without removing it
    public Object dequeue() {
        if (this.lst.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Object dequeued = this.lst.getFirst();
        this.lst = this.lst.removeFirst();
        return dequeued;
    } //- Removes and returns the object at the beginning of the ua.edu.ucu.immutable.Queue.
    public void enqueue(Object e){
        this.lst = this.lst.addLast(e);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return !lst.isEmpty();
            }

            @Override
            public String next() {
                if (lst.isEmpty()){
                    throw new NoSuchElementException();
                }
                return (String) dequeue();
            }
        };
    }
    //- Adds an object to the end of the ua.edu.ucu.immutable.Queue.
}
