package src.Olivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i=0,j=0;i<list1.size()&&j<list2.size();){
            int tmp1 = list1.get(i);
            int tmp2 = list2.get(j);
            if(tmp1<tmp2){
                res = Math.min(res,tmp2-tmp1);
                i++;
            }
            else{
                res = Math.min(res,tmp1-tmp2);
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */