package src.Olivia;

//NO 213
//try dp
//calculate the max result one with nums[0] and one with nums[len-1]

public class rob2 {
    public int rob(int[] nums) {
        //corner case
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        int[] dp2 = new int[len];
         dp[0]=nums[0];
         dp2[1]=nums[1];
        for(int i=1;i<len-1;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+(i-2>=0?dp[i-2]:0));
        }
        for(int i=2;i<len;i++){
            dp2[i] = Math.max(dp2[i-1],nums[i]+(i-2>=0?dp2[i-2]:0));
        }

        return Math.max(dp[len-2],dp2[len-1]);
    }
}
