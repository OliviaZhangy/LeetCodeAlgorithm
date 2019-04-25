package Olivia;

import java.util.Map;

//NO 64
//try use DP
public class MinPathSum64 {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        dp[0][0] = grid[0][0];
//
//        /* using dp */
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j != 0) {
//                    dp[i][j] = dp[i][j - 1] + grid[i][j];
//                }
//                if (j == 0 && i != 0) {
//                    dp[i][j] = dp[i - 1][j] + grid[i][j];
//                }
//                if (i != 0 && j != 0) {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    public int minPathSum(int[][] grid) {
        //corner case
        if(grid.length==0||grid[0].length==0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //at rows = 0
                if(i==0&&j!=0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                //at cols = 0
                if(j==0&&i!=0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                //regular one
                if(j!=0&&i!=0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}
