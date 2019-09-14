package src.Olivia;

//NO 734

import java.util.*;

public class areSentencesSimilar {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        //corner case
        if(words1.length!=words2.length) return false;
        Map<String, HashSet<String>> map = new HashMap<>();
        for(List<String> cur:pairs){
            String s1 = cur.get(0);
            String s2 = cur.get(1);
            if(!map.containsKey(s1))
                map.put(s1,new HashSet<>());
            if(!map.containsKey(s2))
                map.put(s2,new HashSet<>());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
        for(int i=0;i<words1.length;i++){
            if(words1[i].equals(words2[i])) continue;
            String s1 = words1[i];
            String s2 = words2[i];
            if(!map.containsKey(s1)) return false;
            Set<String> set = map.get(s1);
            if(!set.contains(s2)) return false;
        }
        return true;
    }
}
