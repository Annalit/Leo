public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length ==0)
            return 0;
        int[] res1 = new int[length];
        int[] res2 = new int[length];
        int result = 0;
        int min = prices[0];
        int max = prices[length-1];
        for(int i = 1; i < length; i++){
            res1[i] = Math.max(res1[i-1], prices[i] - min);//is it possible to generate a new? and how is it generated?
            min = Math.min(min, prices[i]);//is it possible to generate a new? and how is it generated?
        }
        
        for(int i = length-2; i >= 0; i--){
            res2[i] = Math.max(res2[i+1], max-prices[i]);
            max = Math.max(max, prices[i]);
        }
        for(int i = 0; i < length; i++){
            result = Math.max(res1[i]+res2[i], result);
        }
        return result;
    }
}
