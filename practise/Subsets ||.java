//https://leetcode.com/problems/subsets-ii/
public class Solution{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] num){
        Arrays.sort(num);
        List<Integer> inner = new ArrayList<Integer>();
        helper(num, inner);
        return result;
    }
    
    void helper(int[] num, List<Integer> inner){
        result.add(inner);
        if(num.length == 0){
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(i>0 && num[i] == num[i-1]){
                continue;
            }
            List<Integer> temp = new ArrayList<Integer>(inner);
            temp.add(num[i]);
            int[] b = Arrays.copyOfRange(num, i+1, num.length );
            helper(b, temp);
        }
    }
}
//当然这道题也可以用hash。。没难度就是了
public class Solution{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    hashMap hash = new hashMap();
    public List<List<Integer>> subsetsWithDup(int[] num){
        Arrays.sort(num);
        List<Integer> inner = new ArrayList<Integer>();
        helper(num, inner);
        return result;
    }
    
    void helper(int[] num, List<Integer> inner){
        if(hash.add(inner)){
          result.add(inner);
        }
        if(num.length == 0){
            return;
        }
        for(int i = 0; i < num.length; i++){
            List<Integer> temp = new ArrayList<Integer>(inner);
            temp.add(num[i]);
            int[] b = Arrays.copyOfRange(num, i+1, num.length );
            helper(b, temp);
        }
    }
}
