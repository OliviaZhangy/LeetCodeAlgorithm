package src.Olivia;

//NO 169
//bit manipulation

import java.util.Arrays;

public class majorityElement {
    public int majorityElement(int[] nums) {
    //sorting
        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}
