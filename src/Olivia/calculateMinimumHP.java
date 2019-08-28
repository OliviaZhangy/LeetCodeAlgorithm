package src.Olivia;


//NO 174
//DP
//hard

public class calculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        //dp[i][j] store the minHP to store at the place, calculate from bottom right to top left
        int[][] dp = new int[rows+1][cols+1];
        for(int i=0;i<=rows;i++){
            dp[i][cols] = Integer.MAX_VALUE;
        }
        for(int i=0;i<cols;i++){
            dp[rows][i] = Integer.MAX_VALUE;
        }
        dp[rows][cols-1] = 1;
        dp[rows-1][cols] = 1;
        for(int i=rows-1;i>=0;i++){
            for(int j=cols-1;j>=0;j++){
                //need hp to be what?
                int need = Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
                dp[i][j] = need<=0?1:need;

            }
        }
        return dp[0][0];

    }
}
