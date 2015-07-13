public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode q = p;
        ListNode m = new ListNode(-1);
        m = head;
        ListNode n = m;
        while(q != null && q.next != null){
            p = p.next;
            q = q.next.next;
        }
        while(n != null && n.next != null){
            m = m.next;
            n = n.next.next;
        }
        // p.next will be the start of second list
        // m is the end of the reverse list(exclusive)
        p = p.next;//this should before the next line, because if after, the p.next is null
        //because in the code I didn't make them together.
        ListNode fake = reverse(head, m);
        while(fake != null && p != null){
            if(fake.val != p.val){
                return false;
            }
            fake = fake.next;
            p = p.next;
        }
        return true;
    }
    ListNode reverse(ListNode head, ListNode tail){
        ListNode fake = new ListNode(-1);
        ListNode cur = new ListNode(-1);
        cur.next = head;
        while(cur !=null && cur.next != null && cur.next != tail){
            ListNode temp = cur.next.next;
            cur.next.next = fake.next;
            fake.next = cur.next;
            cur.next = temp;
        }
        return fake.next;
    } 
}
