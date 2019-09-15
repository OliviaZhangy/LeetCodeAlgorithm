package src.Olivia;
//NO 375
//dp
//dp[x][y] = i + Math.max(dp[x][i-1],dp[i+1][y]);

public class getMoneyAmount {
    public int getMoneyAmount(int n) {
        if(n==1) return 0;
        int[][] dp = new int[n+1][n+1];
        return Helper(dp,1,n);
    }
    private int Helper(int[][] dp ,int start, int end){
        if(start>=end) return 0;
        if(dp[start][end]!=0) return dp[start][end];
        int res = Integer.MAX_VALUE;
        for(int x=start;x<=end;x++){
            int tmp = x + Math.max(Helper(dp,x+1,end),Helper(dp,start,x-1));
            res = Math.min(res,tmp);
        }
        dp[start][end] = res;
        return res;
    }
}
