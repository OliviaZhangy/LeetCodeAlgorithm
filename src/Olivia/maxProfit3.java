package src.Olivia;
//NO 123 hard
//try dp

import java.util.*;

public class maxProfit3 {


//1
    //right, but cost too much time!!
//    public int maxProfit(int[] prices) {
//        //corner case
//        if (prices.length == 0)
//            return 0;
//        int len = prices.length;
//        int profit = dpHelper(prices,0,prices.length-1);
//        if(prices.length<4)
//            return profit;
//
//        for(int i=1;i+1<len;i++){
//            profit = Math.max(profit,dpHelper(prices,0,i)+dpHelper(prices,i+1,prices.length-1));
//        }
//        return profit;
//    }
//    //to calculate if only choose one as the best choices, return profit
//    private int dpHelper(int[] prices, int startLoc, int endLoc){
//        int len = endLoc-startLoc+1;
//        int[] dp = new int[len];
//        dp[0] = 0;
//        int min = prices[startLoc];
//        int max = 0;
//        for(int i=1;i<len;i++){
//
//            if(prices[startLoc+i]<min){
//                min = prices[startLoc+i];
//            }
//            else{
//                dp[i]=prices[startLoc+i]-min;
//            }
//            max = Math.max(max,dp[i]);
//        }
//        return max;
//    }


//2
    //a tricky solution
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).



//3
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
public int maxProfit(int[] prices) {
    //corner case
    if(prices.length==0)
        return 0;
    int len = prices.length;
    int[][] dp = new int[3][len];
    for(int level=1;level<3;level++){
        int min = prices[0];
        for(int i =1;i<len;i++){
            min = Math.min(min,prices[i]-dp[level-1][i-1]);
            dp[level][i] = Math.max(dp[level][i-1],prices[i]-min);
        }
    }
    return dp[2][len-1];

}

}
