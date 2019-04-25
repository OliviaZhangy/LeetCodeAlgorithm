package src.Olivia;

import java.util.List;

//NO 120
//try dp
//do not need to store all the dp number, just use the last line as the dp table is much more easier

public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //corner case
        if(triangle.size()==0){
            return 0;
        }
        int level = triangle.size();
        int[] dp = new int[level];
        //base case
        List<Integer> tmp = triangle.get(level-1);
        for(int i=0;i<level;i++){
            dp[i] = tmp.get(i);
        }
        //fill the table
        for(int i = level-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
