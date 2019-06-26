package src.Olivia;

//NO 31
//others

import Olivia.Insert57;

import java.util.HashMap;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        //corner case
        if (nums==null||nums.length<=1) return;
        int i = nums.length-2;
        //find the pivot point which is not in the descending order
        while (i>=0&&nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);

    }
    private void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
    private void reverse(int[] nums, int i,int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }

}
