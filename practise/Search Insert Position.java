public class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int mid = 0;
        while (e >= s) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
这道题以前写的时候e都直接等于mid了，不过还是mid - 1比较好一点。。
循环退出的时候其实就是递归里面的s > e
其实这题可以这样也是跟我们取的mid有关系，你会发现最差的时候mid也是s。也就是说当我找到最后一个mid等于s的时候。
A[i - 1] A[i] A[i + 1] A[i + 2] 
因为已经决定了i道i + 2这一段，也就是说最小的是A[i].
A[i]和target的大小关系无从得知，但是如果最后只剩下
A[i] A[i + 1];
如果target < A[i], 然后这个时候end = mid - 1,然而已经溢出。那么之前的s = i就是要插入的位置。
如果target > A[i],这个时候就只剩下A[i + 1], 如果target > A[i + 1], s = i + 2,是正确的插入位置。
如果target < A[i + 1],s = i + 1,也是正确的插入位置。
所以这道题如果用正常的二分查找的方法写起来会方便很多。。。
也就是说，二分查找最后start的位置，一定是>= target的。
