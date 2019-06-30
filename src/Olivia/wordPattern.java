package src.Olivia;

//NO 290
//others

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] tmp = str.split(" ");
        //corner case
        if(pattern.length()!=tmp.length) return false;
       Map<Character,String> map = new HashMap<>();
       for(int i=0;i<tmp.length;i++){
           char cur = pattern.charAt(i);
           String word = tmp[i];
           if(map.containsKey(cur)){
               if(!map.get(cur).equals(word)){
                   return false;
               }
           }
           else{
               //avoid duplicate!!
               if(map.containsValue(word)){
                   return false;
               }
               map.put(cur,word);
           }
       }
       return true;
    }

}
