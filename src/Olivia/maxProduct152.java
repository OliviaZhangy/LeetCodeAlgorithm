package src.Olivia;

//NO 152

public class maxProduct152 {
    public int maxProduct(int[] nums) {
        //corner case
        if(nums.length==1) return nums[0];
        int len = nums.length;
        //store the max
        int[] dp1 = new int[len];
        //store the min, to avoid the negative
        int[] dp2 = new int[len];
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        int res = nums[0];
        for(int i=1;i<len;i++){
            dp1[i] = Math.max(Math.max(nums[i],dp1[i-1]*nums[i]),dp2[i-1]*nums[i]);
            dp2[i] = Math.min(Math.min(nums[i],dp1[i-1]*nums[i]),dp2[i-1]*nums[i]);
            res = Math.max(res,dp1[i]);
        }
        return res;
    }
}
