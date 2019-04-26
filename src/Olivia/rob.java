package src.Olivia;

//NO 198
//try dp

public class rob {
    public int rob(int[] nums) {
        //corner case
        if(nums.length==0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+(i-2>=0?dp[i-2]:0));
        }
        return dp[len-1];
    }
}
