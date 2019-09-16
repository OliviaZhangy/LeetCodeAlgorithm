package src.Olivia;

//NO 731
//ordered map
//

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class MyCalendarTwo {

    TreeMap<Integer,Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //use map to indicate whether it is start or end of an event
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int count = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            count += entry.getValue();
            //cause overlap at this time
            if (count > 2) {
                if (map.get(start) == 1)
                    map.remove(start);
                else
                    map.put(start, map.get(start) - 1);
                if (map.get(end) == -1)
                    map.remove(end);
                else
                    map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */