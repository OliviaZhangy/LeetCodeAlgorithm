package src.Olivia;

//NO 85

import java.util.Arrays;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        //corner case
        if(matrix==null||matrix.length==0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int[] left = new int[cols];
        int[] right = new int[cols];
        Arrays.fill(right,cols);
        int max = 0;
        for(int i=0;i<rows;i++){
            int cur_left = 0;
            int cur_right = cols;
            //update the height
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='0')
                    height[j] = 0;
                else{
                    height[j]++;
                }
            }
            //update the left
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    left[j] = Math.max(cur_left,left[j]);
                }
                else{
                    left[j] = 0;
                    cur_left = j+1;
                }
            }
            //update the right
            for(int j=cols-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j] = Math.min(right[j],cur_right);
                }
                else{
                    right[j] = cols;
                    cur_right = j;
                }
            }
            //update the max
            for(int j=0;j<cols;j++){
                max = Math.max(max,(right[j]-left[j])*height[j]);
            }
        }
        return max;
    }
}
