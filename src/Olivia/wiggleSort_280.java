package src.Olivia;

//NO 280

public class wiggleSort_280 {
    public void wiggleSort(int[] nums) {
            for(int i=0;i<nums.length;i++){
                if(i%2==1){
                    if(nums[i]<nums[i-1])
                        swap(nums,i);
                }
                else{
                    if(i!=0&&nums[i]>nums[i-1])
                        swap(nums,i);
                }
            }
        }
        private void swap(int[] nums, int i){
            int tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }
    }
}
