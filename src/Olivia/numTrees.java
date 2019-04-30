package src.Olivia;


//NO 96
//tree use dp
//https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
//great explanation

public class numTrees {
    public int numTrees(int n) {
        //return an empty tree which is one
        if(n==0) return 1;
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //use j as the root
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
