package src.Olivia;

//NO 162
//search

public class findPeakElement {
    public int findPeakElement(int[] nums) {
        //corner case
        if(nums.length==1) return 0;

       int start = 0;
       int end = nums.length-1;
       while(start<end){
           int mid = start+(end-start)/2;
           //peak at right side
           if(nums[mid]<nums[mid+1]){
               start = mid+1;
           }
           else {
               end = mid;
           }
       }
       return start;
    }
}
