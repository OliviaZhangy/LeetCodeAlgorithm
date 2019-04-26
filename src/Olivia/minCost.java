package src.Olivia;
//NO 256
//use dp

public class minCost {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int rows = costs.length;
        int cols = costs[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<cols;i++){
            dp[0][i] = costs[0][i];
        }
        for(int i=1;i<rows;i++){

                    dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];

                    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];

                    dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];

        }
        int result = Math.min(Math.min(dp[rows-1][0],dp[rows-1][1]),dp[rows-1][2]);
        return result;
    }
}
