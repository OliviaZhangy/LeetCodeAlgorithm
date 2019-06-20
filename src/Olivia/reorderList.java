package src.Olivia;

//NO 143
//list rotation

public class reorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }
    //first: reverse the node from middle 1 2 3 4 5 -> 1 2 3 5 4
    //second: inset each 1 5 2 4 3
    public void reorderList(ListNode head) {
        //corner case
        if(head==null||head.next==null||head.next.next==null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        //find the middle one p1
        while (p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //reverse from mid
        ListNode middle = p1;
        ListNode post = p1.next;
        while(post.next!=null){
            ListNode cur = post.next;
            post.next = cur.next;
            cur.next = middle.next;
            middle.next = cur;
        }

        p1 = head;
        p2 = middle.next;
        while(p1!=middle){
            middle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = middle.next;
        }

    }

}
