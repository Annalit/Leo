public class Solution {
    public int rob(int[] nums) {
     //maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
        int length = nums.length;
        if(nums.length == 0){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, length-1)),helper(Arrays.copyOfRange(nums, 1, length))); 
    }
     
     int helper(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int length = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(nums[0]);
        
        if(length>1)
            res.add(Math.max(res.get(0), nums[1]));
        for(int i = 2; i < length; i++){
            res.add(Math.max(res.get(i-1), nums[i]+res.get(i-2)));
        }
        return res.get(length-1);
    }
}
