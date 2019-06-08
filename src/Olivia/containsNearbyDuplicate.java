package src.Olivia;

//NO 119
//bst

import java.util.HashMap;
import java.util.Map;

public class containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int value = nums[i];
            if(map.containsKey(value)){
                int number = map.get(value);
                if(i-number<=k) return true;
                else map.put(value,i);
            }
            else{
                map.put(value,i);
            }
        }
        return false;
    }
}
