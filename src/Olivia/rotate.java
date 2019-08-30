package src.Olivia;
//No 189

//do it in place
public class rotate {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k==0) return;
        //reverse all
        reverse(nums,0,nums.length-1);
        //reverse to k-1
        reverse(nums, 0,k-1);
        //reverse rest
        reverse(nums,k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
        while (start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
