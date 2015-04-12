//https://leetcode.com/problems/combinations/
public class Solution{
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n,int k){
        List<Integer> inner = new ArrayList<Integer>();
        int[] a = new int[n];
        for(int i = 0; i< n; i++){
            a[i]=i+1;
        }
        helper(a,inner,k);
        return result;
    }
    void helper(int[] right, List<Integer> temp, int k){
        if(temp.size()== k){
            result.add(temp);
            return;
        }
        for(int i = 0;i < right.length; i++){
            List<Integer> templeft = new ArrayList<Integer>(temp);
            templeft.add(right[i]);
            int[] t=Arrays.copyOfRange(right ,i+1,right.length);
            helper(t,templeft,k);    
        }
    }
    
}
