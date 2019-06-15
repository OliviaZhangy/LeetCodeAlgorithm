package src.Olivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//NO 347
//search kth

//Idea is simple. Build a array of list to be buckets with length 1 to sort.
public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result  = new ArrayList<>();
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:nums){
            if(map.get(x)==null){
                map.put(x,0);
            }
            else{
                map.put(x,map.get(x)+1);
            }
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key:map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
              for(int j=0;j<bucket[i].size();j++){
                  result.add(bucket[i].get(j));
                  count++;
                  if(count==k) return result;
              }
            }
        }
        return  result;

    }
}
