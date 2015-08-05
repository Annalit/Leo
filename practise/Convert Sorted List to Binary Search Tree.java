public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
    TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = new ListNode(-1);
        ListNode q = new ListNode(-1);
        p.next = head;
        q.next = head;
        ListNode left = p;
        while (q.next!= null && q.next.next!=null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode mid = p.next;
        p.next = null;
        left = left.next;
//这里需要想的是，当head为空我会返回，那不为空至少是1，是1的时候我的mid都不可能为空的。。。
            TreeNode cur = new TreeNode(mid.val);
            cur.right = helper(mid.next);
            cur.left = helper(left);
            return cur;
    }
}
