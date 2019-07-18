package src.Olivia;

//NO 25


public class reverseKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        //corner case
        if (k == 0 || head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode begin = dummy;
        dummy.next = head;
        int count = 1;
        while(cur!=null){
            if(count%k==0){
                begin = reverse(begin,cur.next);
                cur = begin.next;
            }
            else{
                cur = cur.next;
            }
            count++;
        }
        return dummy.next;
    }
    //dummy->1->2->3 k=2, just reverse to dummy->2->1->3, return listnode 1
    private ListNode reverse(ListNode start, ListNode end){
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode first = cur;
        ListNode post;
        while(cur!=end){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        start.next = pre;
        first.next = end;
        return first;
    }
}
