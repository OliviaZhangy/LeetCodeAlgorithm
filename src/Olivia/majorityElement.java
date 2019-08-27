package src.Olivia;

//NO 169
//bit manipulation

import java.util.Arrays;

public class majorityElement {
    public int majorityElement(int[] nums) {
    //1.sorting
//        Arrays.sort(nums);
//        return nums[nums.length/2];


    //2.bit manipulation
//        int[] bit = new int[32];
//        for (int num: nums)
//            for (int i=0; i<32; i++)
//                if ((num>>(31-i) & 1) == 1)
//                    bit[i]++;
//        int ret=0;
//        for (int i=0; i<32; i++) {
//            bit[i]=bit[i]>nums.length/2?1:0;
//            ret += bit[i]*(1<<(31-i));
//        }
//        return ret;


        //3. Boyer-moore majority veto algorithm
        int count = 1;
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            if(count==0){
                res = nums[i];
                count++;
            }
            else if(res == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return res;


    }

}
