package src.Olivia;

import java.util.*;
//no 381

public class RandomizedCollection {
    private ArrayList<Integer> list;
    private Map<Integer, Set<Integer>> map;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        else{
            Set<Integer> set = new HashSet<>();
            set.add(list.size());
            map.put(val,set);
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        else{
            int loc = map.get(val).iterator().next();
            map.get(val).remove(loc);
            if (loc < list.size() - 1 ) {
                int lastone = list.get(list.size() - 1);
                list.set(loc, lastone);
                map.get(lastone).remove(list.size()-1);
                map.get(lastone).add(loc);
            }
            list.remove(list.size()-1);
            if(map.get(val).isEmpty()) map.remove(val);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get( rand.nextInt(list.size()) );
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */