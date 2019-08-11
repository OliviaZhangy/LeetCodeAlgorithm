package src.Olivia;
//NO 1150

public class isMajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        //corner case
        if(nums.length==0) return false;
        int len = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                len++;
            }
        }
        if(len>nums.length/2) return true;
        return false;
    }

}
