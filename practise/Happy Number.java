public class Solution {
    public boolean isHappy(int n) {
        HashSet check = new HashSet();
        int pre = 0;
        while(pre!=1){
            int count = 0;
            while(n!= 0){
                count += Math.pow(n %10,2);
                n = n/10;
            }
            if(check.contains(count)){
                return false;
            }
            check.add(count);
            pre = count;
            n=pre;
        }
        return true;
    }
}
