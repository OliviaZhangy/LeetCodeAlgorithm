package src.Olivia;

//google oa

import java.util.ArrayList;
import java.util.Arrays;

public class largetsSubArray {
    public int[] largetsSubArray(int[] nums, int k){
       int index = 0;
       for(int i=1;i+k-1<nums.length;i++){
           for(int j=0;j<k;j++){
               if(nums[index+j]<nums[i+j]){
                   index = i;
                   break;
               }
               else if(nums[index+j]>nums[i+j])
                   break;
           }
       }
       return Arrays.copyOfRange(nums,index,index+k);
    }
}
