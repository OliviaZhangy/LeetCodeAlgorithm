package src.Olivia;

//NO 137
//bit manipulation
//https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers

//k is 3, then m = 2, we need two 32-bit integers(x2, x1) as the counter.
// And 2^m > k so we do need a mask. Write k in its binary form: k = '11',
// then k1 = 1, k2 = 1, so we have mask = ~(x1 & x2).
// A complete java program will look like:


public class singleNumber2 {
    public int singleNumber(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for(int cur:nums){
            //count the x1 and x2
            x2 ^= x1&cur;
            x1 ^= cur;

            mask = ~(x1&x2);

            x2 &= mask;
            x1 &= mask;

        }
        return x1;
    }
}
