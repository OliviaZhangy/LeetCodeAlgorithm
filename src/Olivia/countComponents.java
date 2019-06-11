package src.Olivia;

//NO 323
//graph

import java.util.Arrays;

public class countComponents {
    public int countComponents(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums,-1);
        int count = n;

        for(int i=0;i<edges.length;i++){
            int x = find(nums,edges[i][0]);
            int y = find(nums,edges[i][1]);
            if(x!=y){
                nums[x] = y;
                count--;
            }
        }
        return count;
    }
    private int find(int[] nums,int i){
        if(nums[i]==-1) return i;
        return find(nums,nums[i]);
    }
}
