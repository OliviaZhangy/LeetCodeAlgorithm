package src.Olivia;

//NO 81
//search

//The only difference is that due to the existence of duplicates

public class search2 {
    public boolean search(int[] nums, int target) {
        //corner case
        if(nums==null||nums.length==0) return false;
        int start = 0;
        int end = nums.length-1;
        while (start<=end) {
            int mid = start +(end-start)/2;
            if(nums[mid] == target) return true;
            //if left is sorted
            if(nums[start]<nums[mid]){
                if(target<nums[start]||target>nums[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            //if the left part is not sorted
            else if(nums[start]>nums[mid]){
                if(target<nums[mid]||target>nums[end]){
                    end = mid-1;
                }
                else{
                    start = mid + 1;
                }
            }
            //to avoid the duplicate 1111111
            else{
                start++;
            }
        }
        return false;
    }
}
