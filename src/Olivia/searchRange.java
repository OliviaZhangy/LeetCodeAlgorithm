package src.Olivia;

//NO 34
//search

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums==null||nums.length==0) return result;
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = start +(end-start)/2;
            if(nums[mid]==target){
                return stretch(nums,mid);
            }
            else if(nums[mid]<target){
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }
        return result;
    }
    private int[] stretch(int[] nums,int res){
        int p1 = res;
        int p2 = res;
        while (p1>0&&nums[p1-1]==nums[p1]) p1--;
        while (p2<nums.length-1&&nums[p2+1]==nums[p2]) p2++;
        int[] result = new int[]{p1,p2};
        return result;
    }
}
