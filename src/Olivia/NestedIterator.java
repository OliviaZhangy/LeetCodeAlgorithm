package src.Olivia;

//NO 341
//iterator

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public interface NestedInteger {
    public NestedInteger();
    public NestedInteger(int value);
    public boolean isInteger();
    public Integer getInteger();
    public void setInteger(int value);
    public void add(NestedInteger ni);
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    Iterator<Integer> listIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for(NestedInteger cur:nestedList){
            if(cur.isInteger()){
                list.add(cur.getInteger());
            }
            else{
                list.addAll(getAList(cur.getList()));
            }
        }
        listIterator = list.iterator();

    }
    private List<Integer> getAList(List<NestedInteger> list){
        List<Integer> result = new ArrayList<>();
        for(NestedInteger cur:list){
            if(cur.isInteger()){
                result.add(cur.getInteger());
            }
            else{
                result.addAll(getAList(cur.getList()));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        return listIterator.next();
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */