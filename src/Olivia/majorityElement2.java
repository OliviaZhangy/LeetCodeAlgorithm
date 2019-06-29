package src.Olivia;

//NO 229
//others

import java.util.ArrayList;
import java.util.List;

public class majorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        //corner case
        if(nums==null||nums.length==0) return list;
        int n1 = nums[0];
        int n2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==n1){
                count1++;
            }
            else if(nums[i]==n2){
                count2++;
            }
            else if(count1==0){
                n1 = nums[i];
                count1 = 1;
            }
            else if(count2==0){
                n2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        //verify it
        count1 = 0;
        count2 = 0;
        for(int cur:nums){
            if(cur==n1) count1++;
            if(cur==n2) count2++;
        }
        if(count1>nums.length/3) list.add(n1);
        if(n1!=n2){
            if(count2>nums.length/3) list.add(n2);}
        return list;

    }
}
