package src.Olivia;

//NO 91
//try dfs and dp

import java.util.HashMap;
import java.util.Map;

public class numDecodings {
    public int numDecodings(String s) {
    //corner case
        if(s.length()==0)
            return 0;
        int[] dp = new int[s.length()+1];
        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            //when it comes to 0, very important! 01 is not correct
            if(s.charAt(i)=='0')
                continue;
            dp[i] += dp[i+1];
            if(i<=s.length()-2&&Integer.valueOf(s.substring(i,i+2))<=26){
                dp[i] += dp[i+2];
            }

        }
        return dp[0];
    }
}
