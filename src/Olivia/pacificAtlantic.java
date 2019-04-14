package src.Olivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Try using BFS

public class pacificAtlantic {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        //corner case
        if(matrix.length==0||matrix[0].length==0)
            return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] isPac = new boolean[rows][cols];
        boolean[][] isAtl = new boolean[rows][cols];
        Queue<int[]> queuePac = new LinkedList<>();
        Queue<int[]> queueAatl = new LinkedList<>();
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||j==0) {
                    isPac[i][j] = true;
                    queuePac.add(new int[]{i,j});
                }
                if(i==rows-1||j==cols-1) {
                    isAtl[i][j] = true;
                    queueAatl.add(new int[]{i,j});
                }
            }
        }
        Helper(isPac,matrix,queuePac);
        Helper(isAtl,matrix,queueAatl);

        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++) {
                if(isAtl[i][j]==true&&isPac[i][j]==true){
                    result.add(new int[]{i,j});
                }
            }}
            return result;
    }
    private void Helper (boolean[][] isVisited, int[][]matrix,Queue<int[]> queue){
        int rows = matrix.length;
        int cols = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int x = cur[0];
            int y = cur[1];
            //check the top
            if(x-1>=0&&matrix[x-1][y]>=matrix[x][y]&&isVisited[x-1][y]==false){
                isVisited[x-1][y]=true;
                queue.add(new int[]{x-1,y});
            }
            if(x+1<rows&&matrix[x+1][y]>=matrix[x][y]&&isVisited[x+1][y]==false){
                isVisited[x+1][y]=true;
                queue.add(new int[]{x+1,y});
            }
            if(y-1>=0&&matrix[x][y-1]>=matrix[x][y]&&isVisited[x][y-1]==false){
                isVisited[x][y-1]=true;
                queue.add(new int[]{x,y-1});
            }
            if(y+1<cols&&matrix[x][y+1]>=matrix[x][y]&&isVisited[x][y+1]==false){
                isVisited[x][y+1]=true;
                queue.add(new int[]{x,y+1});
            }
        }

    }
}
