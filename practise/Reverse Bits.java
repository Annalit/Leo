一开始是这么写的。。
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] digit = new int[32];
        int res = 0;
        for(int i = 0; i < 32; i++){
            digit[i] = (n>>i)&1;
        }
        //the ith of digit[i] stores the answer[32 - i];
        for(int i = 0; i < 32; i++){
            res += digit[i] << (31 - i);
        }
        return res;
    }
}
然后想起freezen说多想几种方法。。然后改成了这样
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] digit = new int[32];
        int res = 0;
        for(int i = 0; i < 32; i++){
            digit[i] = (n>>i)&1;
            res += digit[i] << (31 - i);
        }
        return res;
    }
}
然后改成了这样,perfect!
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res += ((n>>i)&1) << (31 - i);
        }
        return res;
    }
}
