package src.Olivia;

//NO 259
//two pointers

import java.util.Arrays;

public class threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            int start = i + 1;
            int end = nums.length-1;
            int sum = target - nums[i];
            while(start<end){
                if(nums[start]+nums[end]<sum){
                    //if this can meet the requirement, then (end-start) cases can meet the requirement
                    count += end-start;
                    start++;
                }
                else {
                    end--;
                }
            }

        }
        return count;
    }

}
