package src.Olivia;

//NO 41
//positives


public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //corner case
        if(nums==null||nums.length==0) return 1;
        //count means how many numbers larger than 0, so it should be [1,count+1]
        int k = partition(nums) + 1;
        for(int i=0;i<k;i++){
            int cur = Math.abs(nums[i]);
            if(cur <= k){
                nums[cur-1] = nums[cur-1]<0? nums[cur-1]:-nums[cur-1];
            }
        }
        //find the number between nums[0]-nums[k-1] which is larger than 0
        for(int i=0;i<k;i++){
            if(nums[i]>0) return i+1;
        }
        return k+1;

    }
    private int partition(int[] nums){

        int end = nums.length-1;
        int count = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                count++;
                swap(nums,i,count);
            }
        }
        return count;
    }
    private void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
