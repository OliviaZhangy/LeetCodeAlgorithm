package src.Olivia;

//NO 265 hard
//try dp

public class minCostII {
    public int minCostII(int[][] costs) {
        if(costs.length==0) return 0;
        int rows = costs.length;
        int cols = costs[0].length;
        int[][] dp = new int[rows][cols];
        //base cases
        for(int i=0;i<cols;i++){
            dp[0][i] = costs[0][i];
        }
        for(int i =1;i<rows;i++){
            for(int j=0;j<cols;j++){
                dp[i][j] = minHelper(dp[i-1],j) + costs[i][j];
            }
        }
        return minHelper(dp[rows-1],-1);
    }
    //get the minimum from this row and skip the required index, if loc = -1, return the minimum
    private int minHelper(int[] row, int loc){
        int len = row.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(i==loc) continue;
            min = Math.min(min,row[i]);
        }
        return min;
    }
}
