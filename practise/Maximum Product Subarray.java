public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(nums == null|| len==0){
            return 0;
        }
        int max = nums[0];
        int minlocal = nums[0];
        int maxlocal = nums[0];
        for(int i = 1; i < len; i++){
            int temp = maxlocal;
            maxlocal = Math.max(maxlocal*nums[i], Math.max(nums[i],minlocal*nums[i]));//understand here as array, new and old
            minlocal = Math.min(temp*nums[i], Math.min(nums[i],minlocal*nums[i]));
            max = Math.max(max, maxlocal);
        }
        return max;
    }
}
