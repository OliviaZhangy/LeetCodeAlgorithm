package src.Olivia;

//NO 373
//search kth



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;







public class kSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0) return result;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for(int j=0;j<nums2.length;j++) {
            queue.offer(new Tuple(0,j,nums1[0]+nums2[j]));
        }
        while(k>0&&!queue.isEmpty()) {
            Tuple cur = queue.poll();
            List<Integer> curList = new ArrayList<>();
            curList.add(nums1[cur.x]);
            curList.add(nums2[cur.y]);
            result.add(new ArrayList<Integer>(curList));
            k--;
            if(cur.x==nums1.length-1) continue;
            queue.offer(new Tuple(cur.x+1,cur.y,nums1[cur.x+1]+nums2[cur.y]));
        }
        return result;


    }

}
class Tuple implements Comparable<Tuple>{
    int x, y, val;
    public Tuple(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    @Override
    public int compareTo(Tuple that){
        return this.val-that.val;
    }
}
