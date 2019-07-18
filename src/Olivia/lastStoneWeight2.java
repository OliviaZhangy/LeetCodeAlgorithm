package src.Olivia;

//NO 1049
//DP

//partition array to 2 subsets whose difference is minimal
//S1+S2 = S
//S1-S2 = dif
//dp(i,j)=true if in (0,j) range can achieve sum of i


public class lastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int S = 0;
        int S2 = 0;
        for(int cur:stones){
            S += cur;
        }
        boolean[][] dp = new boolean[S+1][stones.length+1];
        //base case: it is true for all to get 0
        for(int i=0;i<=stones.length;i++){
            dp[0][i] = true;
        }
        for(int i = 1;i<=S/2;i++){
            for(int j=1;j<=stones.length;j++){
                //choose this stone or not
                if(dp[i][j-1]||(i-stones[j-1]>=0)&&dp[i-stones[j-1]][j-1]){
                    dp[i][j] = true;
                    S2 = Math.max(S2,i);
                }
            }
        }
        return S-2*S2;
    }
}
