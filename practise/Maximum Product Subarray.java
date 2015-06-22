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
// why we need local, because we can discard the previous once we get better
//we can always jugde whether join the futher or go back to the past, if we know which is better.
// to keep track of how I made all the choices, so that the next time I can made choice based on my previous one
// get the best one

// whether the new element has some effect on the global? if it is better?
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(nums == null|| len==0){
            return 0;
        }
        int max = nums[0];
        int[] minlocal = new int[len];
        int[] maxlocal = new int[len];
        minlocal[0] = nums[0];
        maxlocal[0] = nums[0];
        for(int i = 1; i < len; i++){
            maxlocal[i] = Math.max(maxlocal[i-1]*nums[i], Math.max(nums[i],minlocal[i-1]*nums[i]));
            minlocal[i] = Math.min(maxlocal[i-1]*nums[i], Math.min(nums[i],minlocal[i-1]*nums[i]));
            max = Math.max(max, maxlocal[i]);
            // only related to the current element
        }
        return max;
    }
}
