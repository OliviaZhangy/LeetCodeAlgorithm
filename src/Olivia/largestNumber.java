package src.Olivia;

//NO 179
//string

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
    public String largestNumber(int[] nums) {
        if(nums.length==0)
            return "";
        //change int[] nums to string[]
        String[] num_s = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            num_s[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(num_s,comp);
        //corner case
        if(num_s[0].charAt(0)=='0'){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for(String cur:num_s){
            result.append(cur);
        }
        return result.toString();
    }
}
