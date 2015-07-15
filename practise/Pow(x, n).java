public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        } 
        int temp = n > 0 ? n : (-n);
        double result = myPow(x, temp / 2);
        result *= result;
        if(temp % 2 == 0){
            if(n < 0){
                return 1.0/result;
            }else{
                return result;
            }
        } else {
            if(n < 0){
                return 1.0/(result*x);
            } else{
                return result * x;
            }
        }
    }
}
2power-3 = 1/8
为什么这种规律都找不出来呢。。无语了-    -
