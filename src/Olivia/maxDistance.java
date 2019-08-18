package src.Olivia;

import java.util.LinkedList;
import java.util.Queue;

//1162
public class maxDistance {
    public int maxDistance(int[][] grid) {
        if(grid.length==0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    que.add(new int[]{i,j});
                    isVisited[i][j] = true;
                }
            }
        }
        int level = 1;
        int max = 0;
        while (!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int[] tmp = que.poll();
                int x = tmp[0];
                int y = tmp[1];
                //check all four directions
                if(x+1>=0&&x+1<rows&&!isVisited[x+1][y]){
                    isVisited[x+1][y] = true;
                    que.add(new int[]{x+1,y});
                    max = Math.max(max,level);
                }
                if(x-1>=0&&x-1<rows&&!isVisited[x-1][y]){
                    isVisited[x-1][y] = true;
                    que.add(new int[]{x-1,y});
                    max = Math.max(max,level);
                }
                if(y+1>=0&&y+1<cols&&!isVisited[x][y+1]){
                    isVisited[x][y+1] = true;
                    que.add(new int[]{x,y+1});
                    max = Math.max(max,level);
                }
                if(y-1>=0&&y-1<cols&&!isVisited[x][y-1]){
                    isVisited[x][y-1] = true;
                    que.add(new int[]{x,y-1});
                    max = Math.max(max,level);
                }
            }
            level++;
        }
        return (max==0)?-1:max;
    }
}
