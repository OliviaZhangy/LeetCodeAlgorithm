package src.Olivia;

//NO 142
//two pointers in linked list

public class detectCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Suppose the first meet at step k,the distance between the start node of list and the start node of cycle is s,
    // and the distance between the start node of cycle and the first meeting node is m.
    // Then 2k = (s + m + n1r) = 2(s + m + n2r) ==> s + m = nr.
    // Steps moving from start node to the start of the cycle is just s,
    // moving from m by s steps would be the start of the cycle,
    //covering n cycles. In other words, they meet at the entry of cycle.
    public ListNode detectCycle(ListNode head) {
        //corner case
        if(head==null||head.next==null)
            return null;
        ListNode low = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            low = low.next;
            fast = fast.next.next;
            if(low==fast) {
                ListNode tmp = head;
                while (low!=tmp){
                    low = low.next;
                    tmp = tmp.next;
                }
                return low;
            }

        }
        return null;

    }
    }
