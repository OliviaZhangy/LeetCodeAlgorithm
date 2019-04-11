package Olivia;

public class findMedianSortedArrays4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int m = nums1.length;
        int n = nums2.length;
        int []numsTotal = new int[n+m];
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                numsTotal[k] = nums1[i];
                i++;
            }
            else{
                numsTotal[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            numsTotal[k] = nums1[i];
            k++;
            i++;
        }
        while(j<n){
            numsTotal[k] = nums2[j];
            k++;
            j++;
        }
        k--;
        if(k%2==0){
            return numsTotal[k/2];
        }
        else{
            return (double) (numsTotal[(k+1)/2]+numsTotal[k/2])/2;
        }
    }

}
