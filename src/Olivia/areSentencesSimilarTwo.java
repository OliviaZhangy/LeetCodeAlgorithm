package src.Olivia;


//NO 737
//union find

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class areSentencesSimilarTwo {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        //corner case
        if(words1.length!=words2.length) return false;
        Map<String,String> map = new HashMap<>();
        //union find
        for(List<String> cur:pairs){
            String s1 = find(map,cur.get(0));
            String s2 = find(map,cur.get(1));
            if(!s1.equals(s2))
                map.put(s1,s2);
        }
        for(int i=0;i<words1.length;i++){
            String s1 = words1[i];
            String s2 = words2[i];
            if(s1.equals(s2))continue;
            String parent1 = find(map,s1);
            String parent2 = find(map,s2);
            if(!parent1.equals(parent2))
                return false;
        }
        return true;
    }
    private String find(Map<String,String> map,String word){
        if(!map.containsKey(word))
            map.put(word,word);
        if(map.get(word).equals(word)) return word;
        return find(map,map.get(word));
    }

}
