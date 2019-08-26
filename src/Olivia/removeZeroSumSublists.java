package src.Olivia;


import java.util.HashMap;
import java.util.List;

//NO 1171
//calculate the sum of the previous one
//whenever meet the same sum, remove all the elements between them
public class removeZeroSumSublists {
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode removeZeroSumSublists(ListNode head) {
        //corner case
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer,ListNode> map = new HashMap<>();
        int preSum = 0;
        //it should be start from dummy ([1,-1]--> 0,1,0 so return [])
        ListNode cur = dummy;

        while (cur!=null){
            preSum += cur.val;
            if(!map.containsKey(preSum)){
                map.put(preSum,cur);
            }
            else{
                //connect together
                ListNode pre = map.get(preSum);
                pre.next = cur.next;

            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
