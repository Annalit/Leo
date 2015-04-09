//https://leetcode.com/problems/combination-sum/
public class Solution{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if(candidates == null || candidates.length == 0){
            return result;
        }
        List<Integer> inner = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, inner, 0, target);
        return result;
    }
    void helper(int[] c, List<Integer> inner,int cur, int target){
        
        if(cur > target){
            return;
        }
        if(cur == target){
            result.add(inner);
            return;
        }
        for(int i = 0; i < c.length; i++){
            List<Integer> temp = new ArrayList<Integer>(inner);
            temp.add(c[i]);
            int current= cur;
            current = current + c[i];
            int[] d = new int[c.length-i];
            for(int j=i; j<c.length; j++){
                d[j-i] = c[j];
            }
            helper(d, temp, current, target);
        }
    }

}
