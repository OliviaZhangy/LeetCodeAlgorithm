package src.Olivia;

//NO 398
//random pick


import java.util.Random;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

public class randomPick {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=target) continue;
            count++;
            //to get the probability equal
            if(random.nextInt(count)==0)
                result = i;
        }
        return result;

    }
}
