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
别人的代码，比我的快太多。。
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int re = nums.length + 1;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                if (right - left + 1 == 1)
                        return 1;
                re = Math.min(re, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return re == nums.length + 1 ? 0 : re;
    }
} 
