package Olivia;

//NO 62
//try use dp

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        //special case for m=0||n=0
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        int[][] tmp = new int[m][n];
        tmp[0][0] = 1;
        for(int i=0;i<m;i++){
            tmp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            tmp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                    tmp[i][j] = tmp[i - 1][j]+ tmp[i][j - 1];


            }
        }
        return tmp[tmp.length - 1][tmp[0].length - 1];
    }
}
