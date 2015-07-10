public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, (nums.length - 1) / 2);
    }
    int quickSelect(int[] nums, int low, int high, int median){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = low;
        int j = high;
        int pivot = nums[i];
        while (i < j){
            while (i < j && nums[j] >= pivot)
                j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
    if(i == median){
        return nums[i];
    }
    if (i < median){
        return quickSelect(nums, i + 1, high, median);//这里median都大于i了，自然最小也是i+1
    } else
        return quickSelect(nums, low, i - 1, median);
    }
}
