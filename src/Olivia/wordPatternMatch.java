package src.Olivia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class wordPatternMatch {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(pattern,str,0,0,map,set);
    }
    private boolean isMatch(String pattern,String str, int index1, int index2,Map<Character,String> map,Set<String> set){
        //base case
        if(index1==pattern.length()&&index2==str.length())
            return true;
        if(index1==pattern.length()||index2==str.length())
            return false;
        char cur = pattern.charAt(index1);
        if(map.containsKey(cur)){
            String tmp = map.get(cur);
            // then check if we can use it to match str[index2,]
            if(!str.startsWith(tmp,index2)){
                return false;
            }
            //need to match the rest
            else{
                return isMatch(pattern,str,index1+1,index2+tmp.length(),map,set);
            }

        }
        //if not exists in the map
        else{
            for(int i=index2+1;i<=str.length();i++){
                String now = str.substring(index2,i);
                //if already in the set
                if(set.contains(now))
                    continue;
                map.put(cur,now);
                set.add(now);
                //match the rest
                if(isMatch(pattern,str,index1+1,i,map,set))
                    return true;
                map.remove(cur);
                set.remove(now);
            }

        }
        return false;
    }
}
