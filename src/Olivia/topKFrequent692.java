package src.Olivia;

import java.util.*;


//NO 692

public class topKFrequent692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        //get the word and the freq
        for(String cur: words){
            if(!map.containsKey(cur)) map.put(cur,1);
            else
                map.put(cur,map.get(cur)+1);
        }
        //a priority queue use lamada
        PriorityQueue<Map.Entry<String,Integer>> que = new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()? b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue()

        );

        for(Map.Entry<String,Integer> cur:map.entrySet()){
            que.add(cur);
            if(que.size()>k){
                que.poll();
            }
        }

        while(!que.isEmpty()){
            res.add(0,que.poll().getKey());
        }
        return res;
    }
}
