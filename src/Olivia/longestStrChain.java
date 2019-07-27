package src.Olivia;
//NO 1048

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class longestStrChain {
    public int longestStrChain(String[] words) {
        //corner case
        if(words.length<=1) return words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int max = 0;
        Map<String,Integer> map = new HashMap<>();
        for(String cur:words){
            int tmp = 1;
            for(int i=0;i<cur.length();i++){
              String tmp1 = cur.substring(0,i)+cur.substring(i+1);
              if(map.containsKey(tmp1)){
                  tmp = Math.max(map.get(tmp1)+1,tmp);
              }
          }
            map.put(cur,tmp);
            max = Math.max(tmp,max);
        }
        return max;
    }
}
