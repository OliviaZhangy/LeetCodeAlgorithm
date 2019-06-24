package src.Olivia;

//NO 281
//iterator

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
    private LinkedList<Iterator> list;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
            Iterator move = list.poll();
            int result = (Integer) move.next();
            if(move.hasNext()) list.add(move);
            return result;
    }

    public boolean hasNext() {
        if(list.isEmpty()) return false;
        return true;
    }
}
