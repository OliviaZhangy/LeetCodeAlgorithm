package src.Olivia;
// First deal with Border points turn them into B
//Then make all points who connect to B with letter O become B as well
//turn b to O at last
//using BFS

import java.util.LinkedList;
import java.util.Queue;
class Point{
    int x;
    int y;
    public Point(int a, int b ){
        x = a;
        y = b;
    }
}

public class solve {
        public void solve(char[][] board) {
            //corner case
            if(board.length==0||board[0].length==0){
                return;
            }
            int len_row = board.length;
            int len_col = board[0].length;
            //initial a queue

            for(int i=0;i<len_row;i++) {
                for (int j = 0; j < len_col;j++) {
                    if((i==0||j==0||i==len_row-1||j==len_col-1)&&board[i][j]=='O') {
                        board[i][j] = 'B';
                        Queue<Point> queue = new LinkedList<>();
                        queue.offer(new Point(i, j));

                        while (!queue.isEmpty()) {
                            Point cur = queue.remove();
                            //check the left side
                            int row = cur.x;
                            int col = cur.y;
                            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                                board[row - 1][col] = 'B';
                                queue.add(new Point(row - 1, col));
                            }
                            //check the right side
                            if (row + 1 < len_row && board[row + 1][col] == 'O') {
                                board[row + 1][col] = 'B';
                                queue.add(new Point(row + 1, col));
                            }
                            //check the top
                            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                                board[row][col - 1] = 'B';
                                queue.add(new Point(row, col - 1));}
                            //check the bottom
                            if (col + 1 < len_col && board[row][col + 1] == 'O') {
                                board[row][col + 1] = 'B';
                                queue.add(new Point(row, col + 1));
                            }
                        }
                    }
                }
            }

            for(int i=0;i<len_row;i++) {
                for (int j = 0; j < len_col;j++) {
                    if(board[i][j]=='B'){
                        board[i][j]='O';
                    }
                    else if(board[i][j]=='O'){
                        board[i][j]='X';
                    }

                }
            }

        }}

