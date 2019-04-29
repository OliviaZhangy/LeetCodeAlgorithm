package src.Olivia;

//NO 486
//try dp

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length==0||nums.length==1)
            return true;
        int len = nums.length;
        int[][] dp = new int[len][len];
        return winHelper(nums,0,len-1,dp)>=0;

    }
    private int winHelper(int[] nums,int startLoc, int endLoc,int[][]dp){
        if(startLoc>endLoc){
            return 0;
        }
        if(dp[startLoc][endLoc]!=0){
            return dp[startLoc][endLoc];
        }
        dp[startLoc][endLoc] = Math.max(nums[startLoc]-winHelper(nums,startLoc+1,endLoc,dp),
                nums[endLoc]-winHelper(nums,startLoc,endLoc-1,dp));
        return dp[startLoc][endLoc];
    }
}
