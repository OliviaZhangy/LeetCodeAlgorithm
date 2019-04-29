package src.Olivia;

//NO 377
//try use dp

import java.util.Arrays;

public class combinationSum4 {

    // 3ms solution not fast
//    public int combinationSum4(int[] nums, int target) {
//        if(target==0) return 0;
//        if(nums.length==0) return 0;
//        Arrays.sort(nums);
//        int[] dp = new int[target+1];
//        for(int i=0;i<=target;i++){
//            for(int cur:nums){
//                if(cur>i) break;
//                else if(cur==i){
//                    dp[i]++;
//                }
//                else{
//                    dp[i] += dp[i-cur];
//                }
//            }
//        }
//        return dp[target];
//    }
    public int combinationSum4(int[] nums, int target) {
        if(target==0) return 0;
        if(nums.length==0) return 0;
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return combineHelper(nums,target,dp);

    }
    private int combineHelper(int[]nums,int target,int[] dp){
        if(dp[target]!=-1){
            return dp[target];
        }
        int result = 0;
        for(int i=0;i< nums.length;i++){
            if(target>=nums[i]){
                result += combineHelper(nums,target-nums[i],dp);
            }
        }
        dp[target] = result;
        return result;
    }

}
