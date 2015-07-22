public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int p = 0, q = 0, cur = 0, min = Integer.MAX_VALUE;
        while (p < len) {
            cur = nums[q];
            while (cur < s && q < len - 1) {
                q++;
                cur +=nums[q];
            }
            if (cur >= s)
                min = Math.min(q - p + 1, min);
            p++;
            q = p;
        }
        return min;
    }
}
