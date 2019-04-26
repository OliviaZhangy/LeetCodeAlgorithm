package src.Olivia;


//NO 221
//try DP
public class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        //base case for row 0 and col 0
        for(int i=0;i<rows;i++){
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                max = 1;
            }
        }
        for(int j=0;j<cols;j++){
            if(matrix[0][j]=='1'){
                dp[0][j]=1;
                max = 1;
            }

        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][j]=='1'){
                    if(dp[i-1][j-1]!='0'&&dp[i][j-1]!='0'&&dp[i-1][j]!='0'){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
