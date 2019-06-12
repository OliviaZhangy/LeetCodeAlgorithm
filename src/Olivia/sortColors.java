package src.Olivia;

//NO 75
//two pointers


//one pass way using three pointers
public class sortColors {
    public void sortColors(int[] nums) {
        int n0 = -1;
        int n1 = -1;
        int n2 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                n2++;
                nums[n2] = 2;
                n1++;
                nums[n1] = 1;
                n0++;
                nums[n0] = 0;

            }
            else if(nums[i]==1){
                n2++;
                nums[n2] = 2;
                n1++;
                nums[n1] = 1;
            }
            else{
                n2++;
                nums[n2] = 2;
            }
        }

    }
}
