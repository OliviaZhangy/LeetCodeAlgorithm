package Olivia;

public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        //special case for only one number
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<nums.length;i++) {
            dp[i] = (dp[i - 1] > 0 ? dp[i - 1] : 0) + nums[i];
            max = Math.max(dp[i],max);
        }
        return max;
    }
}