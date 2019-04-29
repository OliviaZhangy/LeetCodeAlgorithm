package src.Olivia;
//NO 416
//try dp

import java.util.Arrays;

public class canPartition {
    public boolean canPartition(int[] nums) {
        if(nums.length==0) return true;
        int sum = 0;
        for(int cur:nums){
            sum += cur;
        }
        Arrays.sort(nums);
        if(sum%2==1) return false;
        return canHelper(nums,sum/2,0);
    }
    private boolean canHelper(int[] nums,int sum,int startLoc){
        if(sum==0)
            return true;

        else if(sum>0&&startLoc<= nums.length-1){

            for(int i=startLoc;i<nums.length;i++){
                // very important line to reduce the time, otherwise it will be LTE
                if(i>startLoc&&nums[i]==nums[i-1]) continue;
                if(sum-nums[i]<0) break;
                if(canHelper(nums,sum-nums[i],i+1))
                return true;
            }
        }
        return false;
    }
}
