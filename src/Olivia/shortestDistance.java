package src.Olivia;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Try using BFS
public class shortestDistance {
    public int shortestDistance2(int[][] grid) {
        int result = -1;
        //corner case
        if(grid.length==0||grid[0].length==0){
            return result;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> root = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    root.add(new int[]{i,j});
                }
                else if(grid[i][j]==2){
                    grid[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        while(!root.isEmpty()){
            int[] cur = root.remove();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(cur);
            boolean[][] isVisited = new boolean[rows][cols];

            while(!queue.isEmpty()){
                int [] tmp = queue.remove();
                int x = tmp[0];
                int y = tmp[1];
                //check the top
                if(x-1>=0&&grid[x-1][y]!=Integer.MAX_VALUE&&grid[x-1][y]!=1){
                    if(!isVisited[x-1][y]){
                    isVisited[x-1][y]=true;
                    grid[x-1][y] += grid[x][y]+1;
                    queue.add(new int[]{x-1,y});}
                }
                if(x+1<rows&&grid[x+1][y]!=Integer.MAX_VALUE&&grid[x+1][y]!=1){
                    if(!isVisited[x+1][y]){
                    isVisited[x+1][y]=true;
                    grid[x+1][y] += grid[x][y]+1;
                    queue.add(new int[]{x+1,y});}
                }
                if(y-1>=0&&grid[x][y-1]!=Integer.MAX_VALUE&&grid[x][y-1]!=1&&(!isVisited[x][y-1])){
                    if(!isVisited[x][y-1]){
                    isVisited[x][y-1]=true;
                    grid[x][y-1] += grid[x][y]+1;
                    queue.add(new int[]{x,y-1});}
                }
                if(y+1<cols&&grid[x][y+1]!=Integer.MAX_VALUE&&grid[x][y+1]!=1&&(!isVisited[x][y+1])){
                    if(!isVisited[x][y+1]){
                    isVisited[x][y+1]=true;
                    grid[x][y+1] += grid[x][y]+1;
                    queue.add(new int[]{x,y+1});}
                }

            }

        }
        result = Integer.MAX_VALUE;
        //check the shortest distance
        for(int i=0; i<rows;i++){
            for(int j=0;j<cols;j++){
              if(grid[i][j]!=Integer.MAX_VALUE&&grid[i][j]!=1){
                  result = Math.min(result,grid[i][j]);
              }
            }
        }
        return result-1;

    }
}
