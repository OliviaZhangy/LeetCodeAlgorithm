package src.Olivia;

//NO 261
//graph

import java.util.Arrays;

public class validTree {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums,-1);
        //use union find
        for(int i=0;i<edges.length;i++){
            int x = find(nums,edges[i][0]);
            int y = find(nums,edges[i][1]);
            if(x==y) return false;

            //union
            nums[x] = y;
        }
        return edges.length==n-1;
    }
    private int find(int[]nums,int i){
        if(nums[i]==-1) return i;
        return find(nums,nums[i]);
    }
}
