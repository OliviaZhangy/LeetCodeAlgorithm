package src.Olivia;

//NO 240
//search matrix
//just search from the top right corner
public class searchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner case
        if(matrix==null||matrix.length==0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1;
        while(col>=0&&row<=rows-1){
            if(matrix[row][col]==target){
                return true;}
            else if(matrix[row][col]<target){
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}
