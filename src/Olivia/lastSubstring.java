package src.Olivia;

import java.util.*;


//NO 1163
public class lastSubstring {
    public String lastSubstring(String s) {

        String pre = "";
        Map<Character, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
       List<Integer> list = map.get(map.keySet().iterator().next());
        if(map.size()==1) return s;

        for (int i :list){

                String tmp = s.substring(i);
                if(tmp.compareTo(pre)>0) pre = tmp;

        }
        return pre;
    }
}

