package src.Olivia;


//NO 403
//hard

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class canCross {
    public boolean canCross(int[] stones) {
       //use hash map to store the stone and the steps it could take
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int cur:stones){
            map.put(cur,new HashSet<>());
        }
        map.get(0).add(1);
        for(int i=0;i<stones.length;i++){
            Set<Integer> tmp = map.get(stones[i]);
            for(int now:tmp){
                int tmp_stone = stones[i]+now;
                if(stones[i]+now==stones[stones.length-1]) return true;
                if(map.containsKey(tmp_stone)){
                    map.get(tmp_stone).add(now);
                    map.get(tmp_stone).add(now+1);
                    if(now-1>0) map.get(tmp_stone).add(now-1);
                }
            }
        }
        return false;

    }
}
