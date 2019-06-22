package src.Olivia;

//NO 289
//bit manipulation

//[2nd bit, 1st bit] = [next state, current state]
//
//- 00  dead (next) <- dead (current)
//- 01  dead (next) <- live (current)
//- 10  live (next) <- dead (current)
//- 11  live (next) <- live (current)

public class gameOfLife {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int count = countNeighbour(board,i,j);
                //
                if(board[i][j]==1&&count>=2&&count<=3){
                    //become 11
                    board[i][j]=3;
                }
                if(board[i][j]==0&&count==3){
                    //become 10
                    board[i][j] =2;
                }
            }
        }
        //get the first number
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] >>= 1;
            }
        }

    }
    private int countNeighbour(int[][]board,int row,int col){
        int count = 0;
        for (int x = Math.max(row - 1, 0); x <= Math.min(row + 1, board.length - 1); x++) {
            for (int y = Math.max(col - 1, 0); y <= Math.min(col + 1, board[0].length - 1); y++) {
                count += board[x][y] & 1;
            }
        }
        count -= board[row][col] & 1;
        return count;
    }
}
