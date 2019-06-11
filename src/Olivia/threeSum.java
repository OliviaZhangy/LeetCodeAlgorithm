package src.Olivia;

//NO 15
//two pointer

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//three sum

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0;i<nums.length-3;i++){
            //add one line to break because array is sorted
            if(nums[i]>0) break;
            if(i==0||nums[i]!=nums[i-1]){
                int start = i+1;
                int end = nums.length-1;
                int sum = 0 - nums[i];
                while(start<end){
                    if(nums[start]+nums[end]==sum){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[start]);
                        cur.add(nums[end]);
                        result.add(new ArrayList<Integer>(cur));
                        //skip the duplicate
                        while(start<end&&nums[start]==nums[start+1]) start++;
                        while(start<end&&nums[end]==nums[end-1]) end--;
                        start++;
                        end--;

                    }
                    else if(nums[start]+nums[end]<sum){
                        while(start<end&&nums[start]==nums[start+1]) start++;
                        start++;
                    }
                    else{
                        while(start<end&&nums[end]==nums[end-1]) end--;
                        end--;
                    }

                }
            }
        }
        return result;
    }
}
