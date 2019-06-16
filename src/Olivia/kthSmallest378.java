package src.Olivia;

//NO 378
//search kth

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
//not search the index, search the range

public class kthSmallest378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low<high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = n-1;
            for(int i=0;i<n;i++){
                while (j>=0&&matrix[i][j]>mid){
                    j--;
                }
                count += j+1;
            }
            if (count<k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return low;
    }
}
