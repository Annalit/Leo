public class Solution {
    public int singleNumber(int[] nums) {
        int[] digit = new int[32];
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < nums.length; j++){
                digit[i] += (nums[j]>>i)&1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++){
            res += (digit[i] % 3) << i;
        }
        return res;
    }
}
第六行，是把所有数的第i位全部加起来，
反正一个数最多也只有32位啦。然后我们就得到一个32位的数组。
然后每一位取余数，一般都会是0，
其实这里也可以这么写
 if((digit[i] % 3) != 0){
      res += (digit[i] % 3) << i;}
  比如要求的数是100010000
  显然就是两个1乘以它所在的位数，然后加起来。
  不过因为0乘以多少都是0，所以不用判断也ok的啦
