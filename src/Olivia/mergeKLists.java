package src.Olivia;

//NO 23


import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //use priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null|lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(int i=0;i<lists.length;i++){
           if(lists[i]!=null){
               queue.add(lists[i]);
           }
        }
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            tail.next = cur;
            tail = cur;
            if(cur.next!=null) queue.offer(cur.next);
        }
        return dummy.next;
    }
}
