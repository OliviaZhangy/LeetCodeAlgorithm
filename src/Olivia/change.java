package src.Olivia;

//NO 518
//dp: backpack problem

public class change {
    public int change(int amount, int[] coins) {
        //corner case
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i=1;i<coins.length+1;i++){
            dp[i][0] = 1;
            for(int j=1;j<amount+1;j++){
                //dp(i,j) = 1.not choose ith coin: dp(i-1,j) + 2. choose ith coin dp(i,j-ith coin)
                if(j-coins[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
