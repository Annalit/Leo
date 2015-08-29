public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int rol = len - k + 1;
        int[] res = new int[rol];
        int p = 0;
        int temp = 0;
        while (p < len){
            if (queue.isEmpty() || nums[queue.peekLast()] >= nums[p]) {
                queue.offerLast(p);
            } else {
            	while (!queue.isEmpty()&&nums[queue.peekLast()] < nums[p]) {
            		queue.pollLast();
            	}
            	queue.offerLast(p);
            }
            if (p - temp + 1 == k) {
                int first = queue.peekFirst();
                res[temp] = nums[first];
                if (nums[temp] == nums[first]) {
                    queue.pollFirst();
                }
                temp++;
            }
            p++;
        }
        return res;
    }
}
The above algorithm could be proven to have run time complexity of O(n). 
This is because each element in the list is being inserted and then removed at most once.
Therefore, the total number of insert + delete operations is 2n.
