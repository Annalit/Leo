public class Solution{
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] num){
        List<Integer> inner = new ArrayList<Integer>();
        helper(num,inner);
        return result;        
    }
    void helper(int[] s, List<Integer> inner){
        if(s.length == 0){
             result.add(inner);
        }
        for(int i = 0;i < s.length; i++){
            List<Integer> innertemp = new ArrayList<Integer>(inner);
            innertemp.add(s[i]);
            int[] t=new int[s.length-1];
            int count=0;
            for(int j=0;j < s.length; j++){
                if(j == i){
                    continue;
                }
                t[count]=s[j];
                count++;
            }
            helper(t, innertemp);    
        }

    }
}
