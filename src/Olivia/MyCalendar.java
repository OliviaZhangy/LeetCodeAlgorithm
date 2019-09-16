package src.Olivia;

//NO 729

import java.util.TreeMap;

class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
         map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
         if(map.floorKey(start)!=null){
             if(map.get(map.floorKey(start))>start) return false;
         }
        if(map.ceilingKey(start)!=null){
            if(map.ceilingKey(start)<end) return false;
        }
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
