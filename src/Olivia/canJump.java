package src.Olivia;


//NO 55
//Greedy

//max count points to the furthest index

public class canJump {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) return false;
        int maxCount = 0;
        for(int i=0;i<nums.length;i++){
            //cannot get to the current point
            if(maxCount<i) return false;
            maxCount = Math.max(maxCount,i+nums[i]);
            if(maxCount>=nums.length-1) return true;
        }
        return true;
    }
}
