package src.Olivia;

//NO 33
//search

public class search {
    public int search(int[] nums, int target) {
        //corner case
        if(nums==null||nums.length==0) return -1;
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<end){
            mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>nums[end]){
                if(target>nums[mid]||target<=nums[end]){
                    start = mid + 1;
                }
                else{
                   end = mid-1;
                }
            }
            else {
                if(target>nums[mid]&&target<=nums[end]){
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
            }
        }
        if(start==end&&nums[start]==target) return start;
        return -1;
    }
}
