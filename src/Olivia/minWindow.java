package src.Olivia;

//NO 76

import java.util.HashMap;

public class minWindow {
    public String minWindow(String s, String t) {
        //corner case
        if(s==null||s.length()<t.length()||t.length()==0)
            return "";
        HashMap<Character,Integer> map = new HashMap<>();
        //put t into the hash map
        for(char c:t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int right = 0;right<s.length();right++){
            char tmp = s.charAt(right);
            if(map.containsKey(tmp)){
                map.put(tmp,map.get(tmp)-1);
                if(map.get(tmp)>=0){
                    count++;
                }
            }
            while (count==t.length()){
                if(right-left+1<minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left))>0){
                        count--;
                    }
                }
                left++;
            }
        }
        if(minLen>s.length()) return "";
        return s.substring(minLeft,minLeft+minLen);
    }
}
