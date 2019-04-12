package src.Olivia;
// First deal with Border points turn them into B
//Then make all points who connect to B with letter O become B as well
//turn b to O at last
//using BFS

import java.util.LinkedList;
import java.util.Queue;

public class solve {
    public void solve(char[][] board) {
        //corner case
        if(board.length==0||board[0].length==0){
            return;
        }
        int len_row = board.length;
        int len_col = board[0].length;
        //initial a queue
        Queue<point> queue= new LinkedList<>();
        for(int i=0;i<len_row;i++){
            for(int j=0;j<len_col);
        }


    }

}
class point{
    int x;
    int y;
    point(int a, int b ){
        x = a;
        y = b;
    }
}
