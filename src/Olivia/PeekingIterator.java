package src.Olivia;

//NO 284
//iterator

import java.util.Iterator;
import java.util.LinkedList;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

    private LinkedList<Integer> list;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new LinkedList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.remove();
    }

    @Override
    public boolean hasNext() {
        if (list.isEmpty()) return false;
        return true;
    }
}
