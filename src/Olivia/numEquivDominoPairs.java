package src.Olivia;


import java.util.HashMap;
import java.util.Map;

//NO 1128
public class numEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int[] cur:dominoes){
            int x = Math.min(cur[0],cur[1]);
            int y = Math.max(cur[0],cur[1]);
            int key = x*10+y;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else{
                map.put(key,1);
            }
        }
        for(int cur:map.values()){
            res += cur*(cur-1)/2;
        }
        return res;
    }
}
