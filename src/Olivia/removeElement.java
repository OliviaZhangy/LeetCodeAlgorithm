package src.Olivia;

//NO 27
//two pointers

public class removeElement {
    public int removeElement(int[] nums, int val) {
        //corner case
        if(nums==null|nums.length==0)
            return 0;
        int pointer = 0;
        for(int i=0;i<nums.length;i++){
            while(i<nums.length&&nums[i]==val){
                i++;
            }
            if(i==nums.length) break;
            nums[pointer] = nums[i];
            pointer++;
        }
        return pointer;
    }
}
