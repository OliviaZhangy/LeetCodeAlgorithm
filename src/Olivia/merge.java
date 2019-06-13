package src.Olivia;

//NO 88
//two pointers

public class merge {
    //from end to start is more easy
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int end = m+n-1;
        while (p2>=0){
            if(p1<0||nums1[p1]<nums2[p2]){
                nums1[end] = nums2[p2];
                end--;
                p2--;
            }
            else{
                nums1[end] = nums1[p1];
                end--;
                p1--;
            }
        }
    }
}
