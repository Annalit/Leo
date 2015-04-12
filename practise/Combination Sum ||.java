https://leetcode.com/problems/combination-sum-ii/
public class Solution{
    List<List<Integer>> result = new ArrayList<List<Integer>>(); 
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<Integer> inner = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(inner, num, target, 0);
        return result;
    }
    void helper(List<Integer> inner, int[] num, int target, int count){
        if(count > target){//when to return to the outer loop? is it always after adding? when result adds fails?
            return;
        }
        if(count == target){
            result.add(inner);//first ask when to return, then ask when to add.
            return;
        }
        //the differenece between the this and the palidrome || is the condition is for the result or the List<>.
        for(int i = 0; i < num.length; i++){
            if(i>0&&num[i] == num[i-1]){
                  continue;
            }
            List<Integer> temp = new ArrayList<Integer>(inner);
            temp.add(num[i]);
            int current = count + num[i];
            int[] h = Arrays.copyOfRange(num, i+1, num.length);
            helper(temp, h, target, current);
        }
    }
}
