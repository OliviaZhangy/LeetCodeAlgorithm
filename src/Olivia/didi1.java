package src.Olivia;

import java.lang.reflect.Array;
import java.util.Arrays;


//NO 188
public class didi1 {


        public int maxProfit(int k, int[] prices) {

            //corner case
            if(k==0) return 0;
            if(prices.length<=1) return 0;
            //corner case : unlimited times
            if (k >= prices.length / 2) {
                return quickProfit(prices);
            }

            //state machine
//            int[] buy  = new int[k];
//            int[] sell = new int[k];
//            Arrays.fill(buy,Integer.MIN_VALUE);
//            Arrays.fill(sell,Integer.MIN_VALUE);
//            for(int i=0;i<prices.length;i++){
//                //buy here
//                buy[0] = Math.max(buy[0],-prices[i]);
//                //sell here or do nothing
//                sell[0] = Math.max(sell[0],buy[0]+prices[i]);
//
//                for(int j=1;j<k;j++){
//                    buy[j] = Math.max(buy[j],sell[j-1]-prices[i]);
//                    sell[j] = Math.max(sell[j],buy[j]+ prices[i]);
//                }
//            }
//            return sell[k-1];


            //dp solution
            //dp(i,j)  = the most profit at most i transactions
            //dp(i,j) = max(dp(i-1,j),dp[i-1][t-1]-prices[t]+prices[j])
            //to make it from O(n^2k)->O(nk)
            //tmpMax = max(dp[i-1][t-1]-prices[t])
            int len = prices.length;
            int[][] dp = new int[k+1][len];
            for(int i=1;i<=k;i++){
                int tmpMax = -prices[0];
                for(int j=1;j<len;j++){
                    dp[i][j] = Math.max(dp[i][j-1],tmpMax+prices[j]);

                    tmpMax = Math.max(tmpMax,dp[i-1][j-1]-prices[j]);
                }
            }
            return dp[k][len-1];
        }

        //max profit with unlimited time
        private int quickProfit(int[] prices){
            int max = 0;
            for(int i = 1;i<prices.length;i++) {
                if (prices[i]>prices[i-1]) {
                    max += prices[i]-prices[i-1];
                }
            }
            return max;
        }


    }

/*
Buy: -1, 1
Sell: 5, 7
*/

