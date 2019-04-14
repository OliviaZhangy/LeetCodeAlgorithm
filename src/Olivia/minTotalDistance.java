package src.Olivia;

import java.util.LinkedList;
import java.util.Queue;

// can choose 1 as the location
//My solution takes longer time, can first convert to a 1D array and get the median
//Because this is the Manhattan Path, choose the median of x and the median of y

public class minTotalDistance {
    public int minTotalDistance(int[][] grid) {
        //corner case
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> home = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    home.add(new int[]{i,j});
                }
            }
        }

        while(!home.isEmpty()){
            int[] cur = home.remove();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    grid[i][j] += Math.abs(i-x)+Math.abs(j-y);
                    if(x==i&&y==j){
                        grid[i][j]--;
                    }

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                min = Math.min(min,grid[i][j]);
            }
        }

        return min;
    }
}
