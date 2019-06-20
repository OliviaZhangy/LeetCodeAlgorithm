package src.Olivia;


//NO 49
//string anagram

import java.util.*;

//use hash map to store one anagram and get the whole value out

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> result = new ArrayList<>();
      if(strs==null||strs.length==0) return result;
        Map<String,List<String>> map = new HashMap<>();
        for(String cur:strs){
            char[] charArray = cur.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if(map.containsKey(key)){
                map.get(key).add(cur);
            }
            else{
                map.put(key,new ArrayList<String>());
                map.get(key).add(cur);
            }
        }
        return new ArrayList<>(map.values());
    }
}
