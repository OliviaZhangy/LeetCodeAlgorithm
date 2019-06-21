package src.Olivia;

//NO 136
//bit manipulation

//xor
//0 0 -> 0
//1 1 -> 0
//0 1 -> 1
//so the same number delete themselves

public class singleNumber {
    public int singleNumber(int[] nums) {
        int x = nums[0];
        for(int i=1;i<nums.length;i++){
            x ^= nums[i];
        }
        return x;
    }
}
