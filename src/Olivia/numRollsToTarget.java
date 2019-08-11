package src.Olivia;

//NO 1155
//dp
//think about the i,j and the corner case

public class numRollsToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        //corner case
        if(d*f<target) return 0;
        if(d*f==target) return 1;
        //dp[i][j], how many possibility that i dices can add to j
        int[][] dp = new int[d+1][target+1];
        //base case
        dp[0][0] = 1;
        for(int i=1;i<=d;i++){
            for (int j=1;j<=target;j++){
                //if j is larger than the largest sum of i dices, there is no possibility
                if(j>i*f){
                    continue;
                }
                else{
                    for(int k=1;k<=f&&k<=j;k++){
                        //dp[i][j] += dp[i-1][j-k]
                        dp[i][j] = (dp[i][j] + dp[i-1][j-k])%1000000007;
                    }
                }
            }
        }
        return dp[d][target];
    }
}
