package src.Olivia;

//NO 53
// try use DP

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        //corner case
        if(nums.length==0)
            return 0;
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0){
                dp[i] = dp[i-1]+nums[i];
            }
            else{
                dp[i] = nums[i];}
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
