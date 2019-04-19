package src.Olivia;

//NO 200
//try use dfs
//因为四周都是水 只要相连 一定是island 将所有1都变为0

import java.security.PublicKey;

public class numIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length==0||grid[0].length==0){
            return count;
        }
         int rows = grid.length;
         int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;

    }
    private void dfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0||i>=rows||j<0||j>=cols||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
