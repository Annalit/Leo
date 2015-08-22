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
下面这个方法是用堆写的，思路其实挺直观的，不过这个方法用递归写的时候没有过。
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        // first comparator
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int len = lists.size();
        Comparator<ListNode> comparatorMin = new ComparatorMin();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, comparatorMin);
        // null
        for (int i = 0; i < len; i++) {
            if (lists.get(i) != null) {
                queue.add(lists.get(i));
            } 
        }
        return generate(queue);
    }
    ListNode generate(PriorityQueue<ListNode> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        ListNode cur = queue.poll();
        if (cur.next != null)
            queue.add(cur.next);
        cur.next = generate(queue);
        return cur;
    }
}
class ComparatorMin implements Comparator<ListNode>{
    public int compare(ListNode cur, ListNode parent) {
        return cur.val - parent.val;
    }
}
Exception in thread "main" java.lang.StackOverflowError at 
java.util.PriorityQueue.siftDown(PriorityQueue.java:667) at java.util.PriorityQueue.poll(PriorityQueue.java:578) 
at Solution.generate(Solution.java:38) at Solution.generate(Solution.java:41) 
下次研究一下
下面这个版本是没有问题的，果然很长时间没有写链表了。
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) { 
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int len = lists.size();
        Comparator<ListNode> comparatorMin = new ComparatorMin();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, comparatorMin);
        for (int i = 0; i < len; i++) {
            if (lists.get(i) != null) {
                queue.add(lists.get(i));
            } 
        }
        if (queue.isEmpty()) {
            return null;
        }
        构造一个新的链表，一开始不知道怎么指定它的下一个节点。。感觉真是一夜回到解放前哦。。
        不断移动一个当前指针，每次循环里面给当前指针指定下一个元素，然后移动当前指针到下一个元素，当然你每次先指定当前指针然后再
        移动理论上也是可以的，只是链表里面我们非常习惯用一种fakehead来做，这样的话给下一个赋值可能会容易一些
        算法上并没有什么过于复杂的地方。
        对了，就是给cur.next赋值的时候，别弄一个方法的局部变量，我们需要的是一个新的节点。。因为方法的局部变量的话，它其实是一直
        会变的。。大囧-     -
        ListNode fakehead = new ListNode(-1);
        ListNode cur = fakehead;
        while (!queue.isEmpty()) {
            ListNode head = queue.poll();
            cur.next = head;
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return fakehead.next;
    }
}
class ComparatorMin implements Comparator<ListNode>{
    public int compare(ListNode cur, ListNode parent) {
        return cur.val - parent.val;
    }
}
