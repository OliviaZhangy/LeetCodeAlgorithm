package src.Olivia;
//NO 115
//DP

public class numDistinct {
    public int numDistinct(String s, String t) {
        //corner case
        if(t.length()>s.length()) return 0;
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len2+1][len1+1];
        //base case : 1. dp[0][i] = 1 because only one way to cover empty
        //            2. dp[i][0] = 0 because empty cannot cover anything except empty
        for(int i=0;i<=len1;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len2][len1];
    }
}
