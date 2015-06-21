public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length; 
        if(length == 0){
            return 0;
        }
        int[] sum = new int[length];
        sum[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < length; i++){
            sum[i] = Math.max(sum[i-1] + nums[i],nums[i]);
            max = Math.max(sum[i],max);
        }
        return max;
    }
}
