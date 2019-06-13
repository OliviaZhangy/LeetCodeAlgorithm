package src.Olivia;


//NO 74
//search

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner case
        if(matrix==null||matrix.length==0) return false;
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        int start = 0;
        int end = rowlen*collen-1;

        while (start<=end) {
            int mid = start + (end - start) / 2;
            int row = mid / collen ;
            int col = mid % collen ;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }
}
