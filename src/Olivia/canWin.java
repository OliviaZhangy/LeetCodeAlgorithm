package src.Olivia;

//NO 294 hard
//try dfs with pruning
// use a map to remember all the messages

import java.util.HashMap;
import java.util.Map;

public class canWin {
    //give a map to memory
    Map<String,Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if(s.length()<2)
            return false;
      for(int i=0;i<s.length();i++){
          if(i-1>=0&&s.charAt(i-1)=='+'&&s.charAt(i)=='+'){
              String tmp = (i==1?"":s.substring(0,i-1))+"--"+s.substring(i+1);
              if((map.containsKey(tmp)&&!map.get(tmp))||(!map.containsKey(tmp))&&!canWin(tmp)){
                  map.put(s,true);
                  return true;
              }
          }
      }
      map.put(s,false);
      return false;

    }
}
