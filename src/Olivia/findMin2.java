package src.Olivia;

//NO 154
//search

public class findMin2 {
    public int findMin(int[] nums) {
        //c.c
        if(nums.length==1) return nums[0];
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;

            if(nums[mid]<nums[end]){
                end = mid;
            }
            else if(nums[mid]>nums[end]){
                start = mid + 1;
            }
            //to avoid the duplicate
            else {
                end--;
            }
        }
        return nums[start];
    }
}
