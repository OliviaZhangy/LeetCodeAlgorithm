package src.Olivia;

//NO 238
//no division

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        //multiply from left to right
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        //multiply from right to left
        //use right to store the multiply value
        int right = 1;
        for(int i= nums.length-2;i>=0;i--){
            right = right*nums[i+1];
            res[i] = res[i]*right;
        }
        return res;
    }
}
