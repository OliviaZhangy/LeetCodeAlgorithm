//package src.Olivia;
//
////NO 384
////shuffle
//
//import java.util.Random;
//
///**
// * Your Solution object will be instantiated and called as such:
// * Solution obj = new Solution(nums);
// * int[] param_1 = obj.reset();
// * int[] param_2 = obj.shuffle();
// */
//
//public class shuffle {
//    private int[] nums;
//    private Random random;
//
//    public Solution(int[] nums) {
//        this.nums = nums;
//        this.random = new Random();
//    }
//
//    /** Resets the array to its original configuration and return it. */
//    public int[] reset() {
//        return this.nums;
//    }
//
//    /** Returns a random shuffling of the array. */
//    public int[] shuffle() {
//        //corner case
//        if(nums==null) return null;
//        int[] result = nums.clone();
//        for (int j=1;j<nums.length;j++){
//          int i = random.nextInt(j+1);
//          swap(result,i,j);
//
//        }
//        return result;
//
//    }
//    private void swap(int[] tmp,int i,int j){
//        int cur = tmp[i];
//        tmp[i] = tmp[j];
//        tmp[j] = cur;
//    }
//}
//
