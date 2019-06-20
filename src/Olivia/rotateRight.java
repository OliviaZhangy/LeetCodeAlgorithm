package src.Olivia;

//NO 61
//rotate list

public class rotateRight {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        //corner case
        if(head==null||head.next==null||k==0) return head;
        int count = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy.next;
        //cur now points to the end
        while(cur.next!=null){
            count++;
            cur = cur.next;
        }

        int realCount = count-k%count;
        ListNode p1 = dummy;
        //p1 points to the node which should be the start
        while(realCount>0){
            p1 = p1.next;
            realCount--;
        }

        //do the rotation
        cur.next = dummy.next;
        dummy.next = p1.next;
        p1.next = null;


        return dummy.next;
    }
}
