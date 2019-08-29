package src.Olivia;


//No 714
public class maxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        //1.dp
//        //corner case
//        if(prices.length<=1) return 0;
//        int[] dp = new int[prices.length];
//        int tmpMax = -prices[0];
//        for(int i=1;i<prices.length;i++){
//            dp[i] = Math.max(dp[i-1],tmpMax+prices[i]-fee);
//            tmpMax = Math.max(tmpMax,dp[i-1]-prices[i]);
//        }
//        return dp[prices.length-1];

        //2.state machine
        if(prices.length<=1) return 0;
        int buy = -prices[0];
        int sell = 0;
        for(int i=1;i<prices.length;i++){
            buy = Math.max(buy,sell-prices[i]);
            sell = Math.max(sell,buy+prices[i]-fee);
        }
        return sell;

    }
}
