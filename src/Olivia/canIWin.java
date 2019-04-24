package src.Olivia;

//NO 464
//TRY DFS
//https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation
//not use map<boolean[] Boolean>,use map<Integer Boolean>

import java.util.HashMap;
import java.util.Map;

public class canIWin {
    Map<Integer, Boolean> map;
    boolean[] isVisited;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
       map = new HashMap<>();
       isVisited = new boolean[maxChoosableInteger+1];
       int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
       if(sum<desiredTotal) return false;
       if(desiredTotal<=maxChoosableInteger) return true;
       return winHelper(desiredTotal);
    }
    private boolean winHelper(int desiredTotal){
        if(desiredTotal<=0) return false;
        int key = transfer(isVisited);
        //try each not selected number
        if(!map.containsKey(key)){
            for(int i=1;i<isVisited.length;i++){
                //not visited
                if(!isVisited[i]){
                    isVisited[i]=true;
                    //check whether the enemy can win
                    if(!winHelper(desiredTotal-i)){
                        map.put(key,true);
                        //need to put false here!
                        isVisited[i]=false;
                        return true;
                    }
                    isVisited[i]=false;
                }
            }
            map.put(key,false);
        }
        //return map.get(key) at last
        return map.get(key);
    }
    //transfer boolean to integer
    private int transfer(boolean[] isVisited){
            int num = 0;
            for(boolean x:isVisited){
                num<<=1;
                if(x){
                    num |= 1;
            }
        }
        return num;
    }

}
