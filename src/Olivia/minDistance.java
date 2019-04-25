package src.Olivia;

//NO 72 hard
//try use DP

public class minDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][]dp = new int[len1+1][len2+1];
        //give the base case
        for(int i=0;i<=len1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=len2;j++){
            dp[0][j] = j;
        }
        //There could be three cases, first compare the char is same or not
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                int cost = (word1.charAt(i-1)==word2.charAt(j-1))?0:1;
                //calculate the minimum between three conditions
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+cost,dp[i-1][j]+1),dp[i][j-1]+1);
            }
        }
        return dp[len1][len2];
    }
}
