public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int pivot2 = makePart(nums, 0, len - 1, 2);
        int pivot1 = makePart(nums, 0, pivot2, 1);
        return;
    }
    public int makePart(int[] nums, int s, int e, int pivot) {
        while (s <= e) {
            // e should always point to >=, s should alaways point to <, unless, swap
            while (s <= e && nums[e] >= pivot) {
                e--;
            }
            while (s <= e && nums[s] < pivot) {
                s++;
            }
            if (e > s) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        return e;
    }
}
处理中间临界点的地方想到了，好开心
接下来尝试一遍过
