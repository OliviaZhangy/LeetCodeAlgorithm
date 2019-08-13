package src.Olivia;

//NO 947
//union find

import java.util.HashMap;
import java.util.Map;

public class removeStones {
    Map<Integer,Integer> map  = new HashMap<>();
    int island = 0;
    public int removeStones(int[][] stones) {
        for(int i=0;i<stones.length;i++){
            unionfind(stones[i][0],10000+stones[i][1]);
        }
        return stones.length-island;
    }
    private void unionfind(int x,int y){
       x = find(x);
       y = find(y);
       //union
       if(map.get(x)!=y){
           map.put(x,y);
           island--;
       }
    }
    private int find(int x){
        if(!map.containsKey(x)) {
            map.put(x,x);
            island++;
        }
       if(x!=map.get(x)){
           //recursive to find father
           map.put(x,find(map.get(x)));
       }
       return map.get(x);
    }
}
