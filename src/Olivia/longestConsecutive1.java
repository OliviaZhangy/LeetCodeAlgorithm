package src.Olivia;

//NO 128
//others hard

import java.util.HashMap;
import java.util.Map;

public class longestConsecutive1 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int cur:nums){
            //avoid duplicate
            if(!map.containsKey(cur)){
            int left = map.containsKey(cur-1)?map.get(cur-1):0;
            int right = map.containsKey(cur+1)?map.get(cur+1):0;
            int len = left+right+1;
            map.put(cur,len);
            max = Math.max(max,len);
            //update the boundary
                map.put(cur-left,len);
                map.put(cur+right,len);
            }

        }
        return max;
    }
}
