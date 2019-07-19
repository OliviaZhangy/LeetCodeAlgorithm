package src.Olivia;

import java.util.Arrays;
import java.util.Comparator;

public class twoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return (o1[1]-o1[0])-(o2[1]-o2[0]);
            }
        });
        int sum = 0;

        for(int i=0;i<costs.length/2;i++){
            sum += costs[i][1] + costs[costs.length-1-i][0];
        }
        return sum;
    }
}
