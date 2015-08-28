TLE
public class Solution {
    public int jump(int[] nums) {
        Queue<Integer> q = new LinkedList<Integer>();
        Boolean flag = false;
        int len = nums.length;
        int count = 0;
        q.add(0);
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int j = 0; j < size; j++){
                int temp = q.poll();//index;
                int cur_breadth = nums[temp] + temp;
                if(cur_breadth >= len - 1){
                    flag = true;
                    break;
                } 
                for(int i = temp + 1; i < cur_breadth; i++){
                    if(nums[i] + i > cur_breadth){
                        q.add(i);
                    }
                }
            }
            if(flag)
                break;
        }
        return count;
    }
}
beautiful code
这里没有想清楚的又是边界条件，
[0],
[1,2]
这里是很容易出问题的，不够还是因为循环定义脑子里不清晰。
画一棵树就知道
---------2
-------5---4
-----1-3-4-5-6
每个节点的值表示它能走的最远距离，也就是以它为root的时候它的孩子的个数，也就是树的宽度
一开始想用queue.size()来保存层，但是其实你会发现每一层的宽度不就是该层的最右点和上层的最右点只差么。。

什么叫一个节点的孩子，就是这个节点能够一次接触到的下一个节点。。
当前层宽度的右节点用curmax表示。
叶子层宽度的右节点用max表示。
在当前层完全走完之前，叶子层的宽度是一直在调整的。
显然当这棵树只有一个节点的时候max 和 curmax 为0；
什么时候count++？count是什么，count是层数。
当从2跳到5的时候，以及4跳到1的时候，也就是说我的当前层发生改变的时候
也就是i = curmax+1的时候。
此时curmax显然马上被赋值为max。所以这道题里面max有一种记录树的宽度的神奇妙用，就像queue的size一样。，
其实这个地方len不一定能到max，max就像一个完全树一样，不过count记录了它的高度就够了。
最后一个代码写的是可以break的
不过感觉下面这个更好，因为更遵循规律，反正我记录层数，走完一遍返回层数就好啦。
因为这个count++的规则更好把握。
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int upper_breadth = 0;
        int max = 0;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(i > upper_breadth){
                count++;
                upper_breadth = max;
            }
            max = Math.max(max, nums[i] + i);
        }
        return count;
    }
}
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int upper_breadth = 0;
        int max = 0;
        int count = 0;
        if(len == 1)
            return count;
        for(int i = 0; i < len; i++){
            if(i > upper_breadth){
                count++;
                upper_breadth = max;
            }
            if(nums[i] + i >= len - 1){
                count++;
                break;
            }
            max = Math.max(max, nums[i] + i);
        }
        return count;
    }
}
为什么就是沉不下心来想呢。
不要害怕，你觉得怪怪的，但是有思路，其实是可以想的，一定只是哪个地方没有想清楚。
不要受到jump1的影响。
这题是求最小步数，其实就是
如果nums[i] + i >= len - 1, return 树的深度。（从0开始）
一个BFS而已。不过刚刚一开始不想去思考的地方其实就是从当前层到下一层，这个地方怎么处理的呢。
就用queue想的话，可以去记录一个当前的最大值，如果没有超过最大值就不用扩展了，如果超过了最大值，就在最大值之后扩展。
其实要是实现起来不用queue，直接用数组也是ok的
待会想
public class Solution {
    public int jump(int[] nums) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int len = nums.length;
        queue.add(0);
        int depth = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            int maxindex = queue.peek() + 1;
            while (size > 0){
                int cur = queue.poll();
                if (nums[cur] + cur >= len - 1) {
                    return depth + 1;
                }
                for (int i = maxindex; i <= nums[cur] + cur; i++) {
                    queue.add(i);
                }
                maxindex = nums[cur] + cur;
                size--;
        }
    }
    return -1;
    }
}
这个代码lintcode过了但是leetcode没有过，可能复杂度还是高了，
if (nums[i] + i >= len - 1) {
        return depth + 2;
}后来加上这个可能会好一些，不过还是过不了。时间复杂度是N吧。。为什么慢了呢
如果接下来我们不用queue的话其实应该也不麻烦，用一个size表现当前层的最远值，用一个max表示下一层的最远值，好像蛮明晰的
public class Solution {
    public int jump(int[] nums) {
        int curlast = -1; // the current size
        int nextlast = -1;// the next max;
        int templast = 0;
        int len = nums.length;
        int level = -1; // next level
        if (nums.length == 1) {
            return 0;
        }
        while (nextlast < len) {
            curlast = nextlast;
            nextlast = templast;
            templast = 0;
            level++;
            for (int i = curlast + 1; i <= nextlast; i++) {
                if (nums[i] + i >= len - 1) {
                    return level + 1;
                }
                templast = Math.max(templast, nums[i] + i);
            }
        }
        return -1;
    }
}
为什么这题可以用数组来实现queue，其实是因为下一行的宽度是由什么决定的
是有当前行num[i] + i中挑出的最大数，来决定下一行的max的
然后下一行就是由当前行最后一个+ 1到max之间组成。。
之前想用一个动态的max记录一个下一行目前为止的最大值，然后每次进队的时候都只进max之后的值，其实这样肯定可以的啦，不过感觉用
队列还是多此一举了。

动态自然可以，但是如果捕捉到这道题从根节点到孩子节点，不是从左往右一个一个把孩子节点加入，而是父节点全部遍历一次，通过算出
下一行孩子的个数，根据数组的性质，把孩子节点一口气加入。。这样思路会明了很多。
