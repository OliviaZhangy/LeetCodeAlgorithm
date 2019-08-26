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

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

//class Solution {
//    public static boolean isWord(String s,char[][] board){
//        //corner case
//        if(s.length()==0)
//            return true;
//        List<int[]> list = new ArrayList<>();
//        char tmp = s.charAt(0);
//        for(int i=0;i<board.length;i++){
//            for(int j=0;j<board[0].length;j++){
//                if(board[i][j]==tmp){
//                    list.add(new int[]{i,j});
//                }
//            }
//        }
//        for(int[] cur:list){
//            if(Helper(s,cur[0],cur[1],board,new boolean[board.length][board[0].length],0))
//                return true;
//        }
//        return false;
//    }
//    private static boolean Helper(String s,int x, int y,char[][] board,boolean[][] isVisited,int idex){
//        //ending case
//        if(idex==s.length()){
//            return true;
//        }
//        if(s.charAt(idex)!=board[x][y]) return false;
//
//        int rows = board.length;
//        int cols = board[0].length;
//
//        //check four directions
//        if(x+1<rows&&!isVisited[x+1][y]){
//            isVisited[x+1][y] = true;
//            if(Helper(s,x+1,y,board,isVisited,idex+1)) return true;
//            isVisited[x+1][y] = false;
//        }
//        if(y+1<cols&&!isVisited[x][y+1]){
//            isVisited[x][y+1] = true;
//            if (Helper(s,x,y+1,board,isVisited,idex+1)) return true;
//            isVisited[x][y+1] = false;
//        }
//        if(x-1>=0&&!isVisited[x-1][y]){
//            isVisited[x-1][y] = true;
//            if (Helper(s,x-1,y,board,isVisited,idex+1)) return true;
//            isVisited[x-1][y] = false;
//        }
//        if(y-1>=0&&!isVisited[x][y-1]){
//            isVisited[x][y-1] = true;
//            if( Helper(s,x,y-1,board,isVisited,idex+1)) return true;
//            isVisited[x][y-1] = false;
//        }
//        return false;
//    }
//
//    public static void main(String[] args){
//        System.out.println(isWord("ABCCED",new char[][]{{'A','B','C','E'},  {'S','F','C','S'},  {'A','D','E','E'}}));
//    }
//}
