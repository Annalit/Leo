         没有想好思路又开始写，该打。
         首先这题一开始会害怕出现很大的数，然后就开始觉得想不清楚了。
         做题之前想象这个题目的答案到底有没有范围，其实是有的啊，最小是1，这个毋容置疑，那么最大呢。
         如果是1，199，9999，99999，怎么办，其实我first missing positive 跟后面的数根本就没有关系啊-    -为什么不认真的往下想，
         多举几个例子。
         然后其实按照两个极端分析，一个极端是都很大，那么第一个missing就是1，一个极端是从1开始顺序，那么missing就是len
         所以其实这道题的值域本身就是1到len的。-----性质1
         什么叫firstmissingpossitive，首先抓问题的定义，不然你连要求的东西是什么都不知道。
         什么叫第一个正数，设为x，我们发现数组被分成了三个部分
         ----negative or zero---positive < x  ---x-----positive > x
         就算不能排序，但其实这题存一个max一个一个比一看就不现实，所以我们找出这个数应该还是要依赖于它的位置。
         可以试着范围排序一下，就像上面。
         
         我们可以首先把负号都放左边去，然后怎么办
         positive < x  ---x-----positive > x x到底在哪里。。。
         因为我们其实不在乎大于x的数，我们其实只是需要 知道positive < x  ---x 这一块
         根据性质1，我们知道它一定是在数组范围内的。
         hashtable！
         我们让这些值和数组下标一一对应不就好了么！因为左边有负数的存在，可以直接让x 对应 x + lenOfNegative
         然后第一个不是对应的下标，- lenOfNegative 其实就是我们要找的数了。。
         当然我觉得好像负数全部赶到右边好一些，我试试~
         其实就是把每个数根据塞到hashtable里面去。但是因为是数组，所以用swap来实现。不过注意的是，swap之后当前值就已经改变了。。。
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int p = len - 1;
        int q = len - 1; // the last positive, if q < 0, no positve
        while (p >= 0) {
            if (nums[p] <= 0) {
                swap(nums, p, q);
                p--;
                q--;
            } else {
                p--;
            }
        }
        if (q < 0) {
            return 1;
        }
        len = q + 1;
        for (int i = 0; i < len; i++) {// should be replaced with nums[cur - 1];
            if (nums[i] > len) {
                continue;
            } else if (i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {// should be i + 1, so this is what is missing
                return i + 1;
            }
        }
        return len + 1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
        
