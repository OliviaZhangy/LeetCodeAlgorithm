package src.Olivia;

//NO 348

//hint
//You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.


public class TicTacToe {

    int[] rows;
    int[] cols;
    int dia1;
    int dia2;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
       rows = new int[n];
       cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        //player 0: add 1,  player 1: add -1
        int add = player==0? 1:-1;
        int len = rows.length;
        rows[row] += add;
        cols[col] += add;
        //dia1
        if(row==col) dia1+= add;
        //dia2
        if(col == len - 1- row) dia2 += add;
        if(Math.abs(rows[row])==len||Math.abs(cols[col])==len||Math.abs(dia1)==len||Math.abs(dia2)==len){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */