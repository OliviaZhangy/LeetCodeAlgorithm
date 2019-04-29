package src.Olivia;

//NO 276
//try dp
//great explanation!!
//https://leetcode.com/problems/paint-fence/discuss/178010/The-only-solution-you-need-to-read

public class numWays {
    public int numWays(int n, int k) {
        if(n==0) return 0;
        if(n==1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]*(k-1)+dp[i-2]*(k-1);
        }
        return dp[n-1];
    }

}
