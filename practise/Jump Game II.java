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
另外，我们一开始我试图
        if(nums[i] + i >= len - 1){
            break;
        }
        但是你很快会发现这样不行，因为这样会对树的高度有误导，我也许是还在当前层走，然后发现如果按该节点跳最大，
        也就是下一层可以超过end，
        也有可能max没有超过当前层。
        总而言之就是，按规矩全部走完，不要跳。
可是当前层也可能是叶子层啊。那么max和curmax就指向同一层了！
因为这里max和curmax的关系是max>=curmax
max > curmax的时候才在不同层。
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
