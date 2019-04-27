package src.Olivia;

//NO 322
//try dp

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0)
            return -1;
        if(amount==0)
            return 0;
        int[] dp = new int[amount+1];
        dp[0]=0;
        //initial with max number
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int price: coins){
                if(i-price>=0){
                    dp[i] = Math.min(dp[i],1+dp[i-price]);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
