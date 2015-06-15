/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //1,2,3，4
 //2,1,3，4 p2,q3
 //3,2,1, 4
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q!=null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head.next = null;
        return p;
    }
}
