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
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode fakehead = new ListNode(-1);
        ListNode cur = new ListNode(-1);
        cur.next = head;
        while (cur != null && cur.next != null){
            ListNode temp = cur.next.next;
            cur.next.next = fakehead.next;
            fakehead.next = cur.next;
            cur.next = temp;
        }
        return fakehead.next;
    }
}
下面这个代码会简洁很多，因为其实就像插入排序一样，其实弄了两个链表，然后把后面的链表一点点调整到前面的链表来，这种方法好好理解哈。
不要把fakehead.next 给随便赋值了！
