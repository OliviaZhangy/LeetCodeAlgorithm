package src.Olivia;

//NO 164
//others

import java.util.Arrays;

public class maximumGap {
    public int maximumGap(int[] nums) {
        //corner case
        if(nums.length<2) return 0;
        //find max and min in the array
        int max = nums[0];
        int min = nums[0];
        for(int cur:nums){
            max = Math.max(max,cur);
            min = Math.min(min,cur);
        }
        //calculate the bucket
        int bucket = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] bucketMin = new int[nums.length-1];
        int[] bucketMax = new int[nums.length-1];
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,Integer.MIN_VALUE);
        for(int cur:nums){
            if(cur==min||cur==max)
                continue;
            int idex = (cur-min)/bucket;
            bucketMin[idex] = Math.min(cur,bucketMin[idex]);
            bucketMax[idex] = Math.max(cur,bucketMax[idex]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i=0;i<nums.length-1;i++){
            //skip the empty bucket
            if(bucketMin[i]==Integer.MAX_VALUE&&bucketMax[i]== Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap,bucketMin[i]-previous);
            previous = bucketMax[i];
        }
        //update the last one in the bucket,max
        maxGap = Math.max(maxGap,max-previous);
        return maxGap;

    }

}
