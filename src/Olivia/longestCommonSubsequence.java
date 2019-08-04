package src.Olivia;

 //No 1143

public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length();
        int cols = text2.length();
        int[][] dp = new int[rows+1][cols+1];
        int max = 0;
        for(int i=1;i<=rows;i++){
            for(int j=1; j<=cols;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return max;
    }
}
