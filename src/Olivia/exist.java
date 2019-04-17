package src.Olivia;
//NO 79
//try using DFS

public class exist {

    public boolean exist(char[][] board, String word) {
        boolean result = false;
        int rows= board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)){
                    //avoid use the first element a second time
                    board[i][j]+=100;
                    result = existHelper(board,word,1,i,j);
                    board[i][j]-=100;
                    if(result) return true;
                }
            }
        }
        return result;

    }
    //a helper function to do DFS to check whether it has the word or not
    private static boolean existHelper(char[][]board,String words, int startLoc,int row, int col){
        if(startLoc==words.length()){
            return true;
        }
        int rows= board.length;
        int cols = board[0].length;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[]dires:directions){
            int x = dires[0]+row;
            int y = dires[1]+col;
            if(x>=0&&x<rows&&y>=0&&y<cols&&words.charAt(startLoc)==board[x][y]){
                //avoid the duplicate
                board[x][y]+=100;
                boolean tmp = existHelper(board,words,startLoc+1,x,y);
                if(tmp) return true;
                board[x][y]-=100;

            }
        }
       return false;
    }
}
