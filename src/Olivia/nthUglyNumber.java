package src.Olivia;
//No 264

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n==1){
            return 1;
        }

        PriorityQueue<Long> q = new PriorityQueue<>();

        int[] nums = new int[]{2,3,5};
        Long result = Long.valueOf(1);
        q.add(result);

        for(int i=0; i<n; i++){
            result = q.poll();

            for(int j:nums){
                Long ug = result*j;
                if(!q.contains(ug)){
                    q.offer(ug);
                }
            }
        }

        return result.intValue();
    }
}
