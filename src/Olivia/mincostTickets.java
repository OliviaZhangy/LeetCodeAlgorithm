package src.Olivia;

import java.util.HashSet;
import java.util.Set;

public class mincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        //corner case
        if(days.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int day:days) set.add(day);
        int[] dp = new int[30];

        for(int i=days[0];i<=days[days.length-1];i++){
            //choose the one day pass
            if(!set.contains(i))
                dp[i%30] = dp[(i-1)%30];
            else{
                //choose one day, seven day and 30 day
                int cost0 = dp[(i-1)%30] + costs[0];
                int cost1 = dp[Math.max(0,i-7)%30] + costs[1];
                int cost2 = dp[Math.max(0,i-30)%30] + costs[2];
                dp[i%30] = Math.min(Math.min(cost0,cost1),cost2);
            }
        }
        return dp[days[days.length-1]%30];
    }
}
