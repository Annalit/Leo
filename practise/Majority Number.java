public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 1;
        int cur = nums.get(0);
        for(int i = 1; i < nums.size(); i ++){
            if (nums.get(i) == cur){
                count++;
            } else if (nums.get(i) != cur){
                if(count == 0){
                    cur = nums.get(i);
                    count = 1;
                } else {
                    count --;
                }
            }
        }
        return cur;
    }
}
这道题很有意思的地方在于，一开始很容易能想到用一个数组记录每个元素的出现的次数。
准备做On的时候，也就是遍历一遍，可是遍历一遍的时候总觉得前面的东西都不能丢下，怎么想都觉得需要一个数组来记录之前的状况。
可是我们真的需要前面所有的记录么
1，2，2，1，3，1
看这里，显然3只出现了一次，根本不用记，
即使是
1，2，2，1，3，4，1，1
3和4 也不用记录。
为什么呢，因为3和4的次数明显小于1或者2的次数(此处是突破口)
然后就开始想了，但是前面1和2两个次数相同呀，我也不可能用一个变量记录下来呀。
那么假如我用一个变量记录，什么时候换下一个，难道是碰到一个换一个么
显然只是i++来控制cur是不够的，我们需要一个count来辅助控制。
什么时候cur改变？不只是cur和array[i]不等，而且count == 0的时候。count = 0的含义是什么呢，就是之前那个cur在前面的次数最多一半！
