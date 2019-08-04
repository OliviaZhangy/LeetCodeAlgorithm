//package src.Olivia;
//
////NO 324
//// search find kth
//
//import java.util.PriorityQueue;
//
//public class wiggleSort {
//    public void wiggleSort(int[] nums) {
//        if(nums==null||nums.length==0||nums.length==1) return;
//        //first find the median of the array
//        int median = findKth(nums,nums.length/2);
//        int len = nums.length;
//        int left = 0;
//        int right = len-1;
//        int i = 0;
//        while (i <= right) {
//
//            if (nums[newIndex(i,n)] > median) {
//                swap(nums, newIndex(left++,n), newIndex(i++,n));
//            }
//            else if (nums[newIndex(i,n)] < median) {
//                swap(nums, newIndex(right--,n), newIndex(i,n));
//            }
//            else {
//                i++;
//            }
//        }
//
//    }
//    private void swap(int[] nums,int i,int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//    private int newIndex(int index, int n) {
//        return (1 + 2*index) % (n | 1);
//    }
//    private int findKth(int[]nums, int k){
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        int count = 0;
//        for(int x:nums){
//            heap.offer(x);
//            count++;
//            if(count>k){
//                heap.poll();
//                count--;
//            }
//
//        }
//        return heap.peek();
//    }
//}
