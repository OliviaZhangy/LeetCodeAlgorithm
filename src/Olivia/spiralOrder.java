package src.Olivia;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //corner case
        if(matrix==null||matrix.length==0)
            return result;
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        //check it is ok or not
        int sum = (rowEnd+1)*(colEnd+1);
        while(rowBegin<=rowEnd&&colBegin<=colEnd){
            //add from left to right
            for(int i=colBegin;i<=colEnd;i++){
                result.add(matrix[rowBegin][i]);

            }
            rowBegin++;
            //add from top to bottom
            for(int i = rowBegin;i<=rowEnd;i++){
                result.add(matrix[i][colEnd]);

            }
            colEnd--;
            //add from right to left
            if(result.size()==sum) break;
            for(int i = colEnd;i>=colBegin;i--){
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if(result.size()==sum) break;
            //add from bottom to up
            for(int i=rowEnd;i>=rowBegin;i--){
                result.add(matrix[i][colBegin]);

            }
            colBegin++;
        }
        return result;
    }

}
