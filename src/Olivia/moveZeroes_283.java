package src.Olivia;

//NO 283
public class moveZeroes_283 {
    public void moveZeroes(int[] nums) {
        //O(n)
        int loc = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(i!=loc){
                    nums[loc] = nums[i];
                    nums[i] = 0;
                }
                loc++;
            }
        }
    }
}
