package src.Olivia;


//NO 220
//bst

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate-iii/discuss/61645/AC-O(N)-solution-in-Java-using-buckets-with-explanation
//Bucketing means we map a range of values to the a bucket.

public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //corner case
        if(k<1||t<0) return false;
        Map<Long,Long> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long remappedNum = (long)nums[i]-Integer.MIN_VALUE;
            long bucket = remappedNum/((long)t+1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}

