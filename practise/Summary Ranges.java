public class Solution {
    // [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums==null || nums.length<1) return  res;
        
        int s=0, e=0;
        while(e<nums.length) {
            if(e+1<nums.length && nums[e+1]==nums[e]+1) {
                e++;
            } else {
                if(s==e) {
                    res.add(Integer.toString(nums[s]));
                } else {
                    String str = nums[s] + "->" + nums[e];
                    res.add(str);
                }
                ++e;
                s = e;
            }
        }
        return res;
    }
}
这题的收获：
一个指针玩不清楚就用两个。
这题的本质是，我是有指针，但是什么时候需要移动它？
写循环判断的时候，什么时候移动它？
写不清楚就用while！
不移动的时候又怎么处理！
只有两种可能！移动和不移动！在[0 - len -1]什么时候直接移动，什么时候要处理才能移动
处理有几种方式来处理。
判断移动的条件对么。
不移动的时候呢，就是加箭头或者不加箭头了。。
