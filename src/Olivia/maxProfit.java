package src.Olivia;

//NO 121
//try DP

public class maxProfit {
    public int maxProfit(int[] prices) {
        //corner case
        if(prices.length==0) return 0;
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0];
        int max = 0;
        for(int i=1;i<len;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else{
            dp[i]=prices[i]-min;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
