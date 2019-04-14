package src.Olivia;
//Try to solve this using BFS

import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix {

public int[][] updateMatrix(int[][] matrix) {
    //corner case
    if(matrix.length==0||matrix[0].length==0){
        return matrix;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(matrix[i][j]==0){
                queue.add(new int[]{i,j});

            }
            else{
                matrix[i][j]=Integer.MAX_VALUE;
            }
        }
    }
    while(!queue.isEmpty()){
        int[] cur = queue.remove();
        int x = cur[0];
        int y = cur[1];
        //check the top
        if(x-1>=0&&matrix[x-1][y]==Integer.MAX_VALUE){
            matrix[x-1][y] = matrix[x][y] + 1;

            queue.add(new int[]{x-1,y});
        }
        if(x+1<rows&&matrix[x+1][y]==Integer.MAX_VALUE){
            matrix[x+1][y] = matrix[x][y] + 1;

            queue.add(new int[]{x+1,y});
        }
        if(y-1>=0&&matrix[x][y-1]==Integer.MAX_VALUE){
            matrix[x][y-1] = matrix[x][y] + 1;

            queue.add(new int[]{x,y-1});
        }
        if(y+1<cols&&matrix[x][y+1]==Integer.MAX_VALUE){
            matrix[x][y+1] = matrix[x][y] + 1;

            queue.add(new int[]{x,y+1});
        }
    }
    return matrix;

    }
}
