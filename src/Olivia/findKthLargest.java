package src.Olivia;

//NO 215
//search kth

import java.util.PriorityQueue;

public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for(int x:nums){
            heap.offer(x);
            count++;
            if(count>k){
                heap.poll();
                count--;
            }

        }
        return heap.peek();
    }
}
