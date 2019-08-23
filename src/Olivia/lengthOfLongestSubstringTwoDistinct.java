package src.Olivia;


//NO 159
//sliding window

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //corner case
        if(s.length()<=2) return s.length();
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        int left = 0;
        int right = 0;
        while (right<s.length()){
            char tmp = s.charAt(right);
            map.put(tmp,map.getOrDefault(tmp,0)+1);
            if(map.get(tmp)==1) count++;
            right++;
            while (count>2){
                char tmps = s.charAt(left);
                map.put(tmps,map.get(tmps)-1);
                if(map.get(tmps)==0){
                    count--;
                }
                left++;
            }
            res = Math.max(res,right-left);

        }
        return res;
    }
}