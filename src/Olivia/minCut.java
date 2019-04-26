package src.Olivia;

//NO 132
//try DP

import java.util.Map;

public class minCut {
    // 1 use dp, but time beat 30%
//    public int minCut(String s) {
//        //corner case
//        if(isPalin(s)) return 0;
//        int len = s.length();
//        int[] dp = new int[len];
//        dp[0] = 0;
//
//        for(int i=1;i<len;i++){
//            int cur = Integer.MAX_VALUE;
//            //consider the new one in a parlin or not
//            for(int j=0;j<i;j++){
//                if(isPalin(s.substring(j,i+1))){
//                cur = Math.min(cur,(j==0?0:dp[j-1]+1));
//                }
//            }
//            dp[i] = Math.min(dp[i-1]+1,cur);
//        }
//        return dp[len-1];
//
//    }
//    //check whether it is palindrome
//    private boolean isPalin (String s){
//        int len = s.length();
//        for(int i=0;i<len/2;i++){
//            if(s.charAt(i)!=s.charAt(len-i-1))
//                return false;
//        }
//        return true;
//    }


    //2 another solution use dp but less time complexity
    public int minCut(String s) {
        // a good way to turn string to array
        char[] c= s.toCharArray();
        int len = c.length;
        int[] dp = new int[len];
        boolean[][] isPali = new boolean[len][len];
        for(int i=0;i<len;i++){
            int min = i;
            for(int j=0;j<=i;j++){
                if(c[i]==c[j]&&(j+1>i-1||isPali[j+1][i-1])){
                    isPali[j][i]=true;
                    min = (j==0?0:Math.min(min,dp[j-1]+1));
                }
            }
            dp[i] = min;
        }
        return dp[len-1];
    }





}
