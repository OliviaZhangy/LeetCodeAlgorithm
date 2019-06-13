package src.Olivia;
//NO 35
//search


public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        //corner case
        if(nums==null||nums.length==0) return 0;
        int start = 0;
        int end = nums.length-1;
        int mid = 0;

        if(target<nums[0]) return 0;
        if(target>nums[end]) return nums.length;

        while(start<=end){
            mid = start +(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return mid;

    }
}
