package src.Olivia;

//No 1000
//dp hard

public class mergeStones {
    public int mergeStones(int[] stones, int K) {
        int len = stones.length;
        //corner case: we can merge k+(k-1)*steps to merge to one
        if((len-1)%(K-1)!=0) return -1;
        //store the sum from  0 to stones[i]
        int[] prefix = new int[len+1];
        for(int i=0;i<len;i++){
            prefix[i+1] = prefix[i] + stones[i];
        }
        int[][] dp = new int[len][len];
        for(int m=K;m<=len;m++){
            for(int i=0;i+m<=len;i++){
                int j = i+m-1;
                dp[i][j] = Integer.MAX_VALUE;
                //find the minimal one from i to j
                for(int mid = i;mid<j;mid += K-1){
                    dp[i][j] = Math.min(dp[i][j],dp[i][mid]+dp[mid+1][j]);
                }
                if((j-i)%(K-1)==0){
                    dp[i][j] += prefix[j+1]-prefix[i];
                }
            }
        }
        return dp[0][len-1];
    }
}
