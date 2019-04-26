package src.Olivia;

//NO 279
//try dp
//dp(n)=min{dp(n-i*i)+1} i*i<n

public class numSquares {
    public int numSquares(int n) {
        //corner case
        if(n==0|n==1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            int j=1;
            while(i-j*j>=0){
                min = Math.min(dp[i-j*j]+1,min);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];

    }
}
