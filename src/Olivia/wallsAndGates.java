package src.Olivia;

//Try to solve this using BFS
//Same as 130 using gate as the root, then run BFS

import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates {
//    public void wallsAndGates(int[][] rooms) {
//        //corner case
//        if(rooms.length==0||rooms[0].length==0){
//            return;
//        }
//        int rows = rooms.length;
//        int cols = rooms[0].length;
//        Queue<int[]> queue = new LinkedList<>();
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<cols;j++){
//                if(rooms[i][j]==0){
//                    //set rooms[i][j] as a root;
//                    queue.add(new int[]{i,j});
//
//                }
//            }
//        }
//
//
//        while(!queue.isEmpty()){
//            int[] cur = queue.remove();
//            int x = cur[0];
//            int y = cur[1];
//            //check the top
//            if(x-1>=0&&rooms[x-1][y]==Integer.MAX_VALUE){
//                rooms[x-1][y] = rooms[x][y]+1;
//                queue.add(new int[]{x-1,y});
//            }
//            //check the bottom
//            if(x+1<rows&&rooms[x+1][y]==Integer.MAX_VALUE){
//                rooms[x+1][y] = rooms[x][y]+1;
//                queue.add(new int[]{x+1,y});
//            }
//            //check the left
//            if(y-1>=0&&rooms[x][y-1]==Integer.MAX_VALUE){
//                rooms[x][y-1] = rooms[x][y]+1;
//                queue.add(new int[]{x,y-1});
//            }
//            //check the right
//            if(y+1<cols&&rooms[x][y+1]==Integer.MAX_VALUE){
//                rooms[x][y+1] = rooms[x][y]+1;
//                queue.add(new int[]{x,y+1});
//            }
//
//        }
//
//    }


    public void wallsAndGates(int[][] rooms) {
        //corner case
        if (rooms.length == 0)
            return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0)
                    que.add(new int[]{i, j});
            }
        }
        Helper(rooms, que);
    }

    private void Helper(int[][] rooms, Queue<int[]> que) {
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = rooms.length;
        int cols = rooms[0].length;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int dis = rooms[cur[0]][cur[1]];
            for (int[] tmp : direction) {
                int x = cur[0] + tmp[0];
                int y = cur[1] + tmp[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = dis + 1;
                    que.add(new int[]{x, y});
                }
            }
        }
    }
}
