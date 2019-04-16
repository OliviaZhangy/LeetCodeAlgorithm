package src.Olivia;
//NO.407 Hard
//Try using BFS
//Answer using heaps!!! priority queue! Nice!!!
// PriorityQueue(int initialCapacity, Comparator comparator):
// Creates a PriorityQueue with the specified initial capacity that orders its elements
// according to the specified comparator.

import java.util.Comparator;
import java.util.PriorityQueue;

public class trapRainWater {
    public class Cell{
        int row;
        int col;
        int height;
        public Cell(int row, int col,int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        //corner case
        if(heightMap.length==0||heightMap[0].length==0)
            return 0;
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        //initial a priority queue with height comparator
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height-o2.height;
            }
        });
        //put border in the queue first
        for(int i =0;i<rows;i++){
            isVisited[i][0]=true;
            isVisited[i][cols-1]=true;
            queue.add(new Cell(i,0,heightMap[i][0]));
            queue.add(new Cell(i,cols-1,heightMap[i][cols-1]));
        }
        for(int i=0;i<cols;i++){
            isVisited[0][i]=true;
            isVisited[rows-1][i]=true;
            queue.add(new Cell(0,i,heightMap[0][i]));
            queue.add(new Cell(rows-1,i,heightMap[rows-1][i]));
        }
        int result = 0;
        //From the border, pick the shortest one first to check its neighbours
        //if the neighbour is shorter, add the height of max height
        //add it to the queue
        int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            Cell cur = queue.poll();
            for(int[]dirs:direction){
                int x = cur.row + dirs[0];
                int y = cur.col + dirs[1];
                if(x>=0&&x<rows&&y>=0&&y<cols&&!isVisited[x][y]){
                    isVisited[x][y] = true;
                    if(heightMap[x][y]<cur.height){
                        result += cur.height-heightMap[x][y];
                        queue.add(new Cell(x,y,cur.height));
                    }
                    else{
                        queue.add(new Cell(x,y,heightMap[x][y]));
                    }
                }
            }
        }
        return result;

    }
}

