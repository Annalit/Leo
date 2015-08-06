现在都不指望能accept。。居然过了。。果然功力大增了现在
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergesort(lists, 0, lists.length - 1);
    }
    ListNode mergesort(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        int mid = s + (e - s) / 2;
        ListNode left = mergesort(lists, s, mid);
        ListNode right = mergesort(lists, mid + 1, e);
        return merge(left, right);
    }
    ListNode merge(ListNode left, ListNode right) {
        ListNode p = new ListNode(-1);
        p.next = left;
        ListNode head = p;
        while (p.next != null && right!= null) {
            if (p.next.val > right.val) {
                ListNode temp = p.next;
                p.next = right;
                right = right.next;
                p.next.next = temp;
                p = p.next;
            } else {
                p = p.next;
            }
        }
        if (right != null) {
            while (p.next != null) {
                p = p.next;
            }
            p.next = right;
        }
        return head.next;
    }
}
