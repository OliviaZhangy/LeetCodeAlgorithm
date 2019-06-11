package src.Olivia;

//NO 16
//two pointers

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            if(i==0||nums[i]!=nums[i-1]){
                int start = i+1;
                int end = nums.length-1;
                int sum = target-nums[i];
                while(start<end){
                    if(nums[start]+nums[end]==sum){
                        return target;
                    }
                    else if(nums[start]+nums[end]<sum){
                        min = Math.min(min,sum-nums[start]-nums[end]);
                        while(start<end&&nums[start]==nums[start+1]) start++;
                        start++;
                    }
                    else{
                        max = Math.min(max,-sum+nums[start]+nums[end]);
                        while(start<end&&nums[end]==nums[end-1]) end--;
                        end--;
                    }

                }
            }
        }
        return min>max?target+max:target-min;
    }
}
