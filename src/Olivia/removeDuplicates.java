package src.Olivia;

//NO 26
//two pointers
//do not need extra space

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        //corner case
        if(nums==null||nums.length==0) return 0;

        int point1 = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[point1] = nums[i];
                point1++;
            }

        }
        return point1;
    }
}
