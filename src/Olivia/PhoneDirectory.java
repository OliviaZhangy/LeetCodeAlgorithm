package src.Olivia;

//NO 379

import java.util.TreeSet;

class PhoneDirectory {
    TreeSet<Integer> set;
    int max;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        set = new TreeSet<>();
        for(int i=0;i<maxNumbers;i++){
            set.add(i);
        }
        max = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(set.isEmpty()) return -1;
        int res = set.iterator().next();
        set.remove(res);
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {

        if(set.contains(number)) return true;
        return false;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(number<0||number>max) return;
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
