package src.Olivia;

//NO 167
//two sum

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class twoSum {

    //use map 2ms
//    public int[] twoSum(int[] numbers, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int[] result = new int[2];
//        for(int i=0;i<numbers.length;i++){
//            if(map.containsKey(target-numbers[i])){
//                result[0] = map.get(target-numbers[i])+1;
//                result[1] = i+1;
//                return result;
//            }
//            else{
//                map.put(numbers[i],i);
//            }
//        }
//        return result;
//    }


    //do not use map 0ms
    public int[] twoSum(int[] number, int target) {
        int[] result = new int[2];
        if(number==null||number.length<2) return result;
        int left = 0;
        int right = number.length-1;
        while(left<right){
            if(number[left]+number[right]==target){
                result[0] = left+1;
                result[1] = right+1;
                return result;
            }
            else if(number[left]+number[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
        return result;
    }
}
