package src.Olivia;

//NO 109
//tree

public class sortedListToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return sortBuilder(head,null);
    }
    private TreeNode sortBuilder( ListNode start,ListNode end){
        if(start==end) return null;
        ListNode first = start;
        ListNode second = start;

        while(first!=end&&first.next!=end){
            first = first.next.next;
            second = second.next;
        }

        TreeNode root = new TreeNode(second.val);
        TreeNode left = sortBuilder(start,second);
        TreeNode right = sortBuilder(second.next,end);
        root.left = left;
        root.right = right;
        return root;
    }
}
