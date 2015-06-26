TLE
public class Solution {
    ArrayList<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> inner = new ArrayList<String>();
        HashSet<Integer> sum = new HashSet<Integer>();
        HashSet<Integer> dif = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        helper(inner,0, n, sum, dif,col);
        return result;
    }
    void helper(ArrayList<String> inner, int q, int n,  HashSet<Integer> sum, HashSet<Integer> dif,HashSet<Integer> col){      
        int len = inner.size()-1;
        if(sum.contains(q+len)||dif.contains(q-len)||col.contains(q)){
        	if(q==n-1){
        		 sum.clear();
                 dif.clear();
                 col.clear();
        	}
            return;
        } else if(len == n-1&&(!inner.isEmpty())){
            result.add(inner);
        	if(len==n-1&&q==n-1){
       		 	sum.clear();
                dif.clear();
                col.clear();
        	}
            return;
        } else if(!inner.isEmpty()){
            sum.add(q+len);
            dif.add(q-len);
            col.add(q);
        }
        for(int i = 0; i < n;i++){    
            ArrayList<String> innertemp = new ArrayList<String>(inner);
            String temp = createString(i, n);
            innertemp.add(temp);
            helper(innertemp, i, n, sum, dif, col);
        }
    }
    String createString(int q, int n){
        StringBuffer sb = new StringBuffer(n);
        for(int i = 0; i < n; i++){
            if(i== q){
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
/**
* pass but low efficiency
**/

public class Solution {
    ArrayList<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> inner = new ArrayList<String>();
        HashSet<Integer> sum = new HashSet<Integer>();
        HashSet<Integer> dif = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        helper(inner,0, n, sum, dif,col);
        return result;
    }
    void helper(ArrayList<String> inner, int q, int n,  HashSet<Integer> sum, HashSet<Integer> dif,HashSet<Integer> col){      
        int len = inner.size()-1;
        if(sum.contains(q+len)||dif.contains(q-len)||col.contains(q)){
            return;
        } else if(len == n-1&&(!inner.isEmpty())){
            result.add(inner);
            return;
        } else if(!inner.isEmpty()){
            sum.add(q+len);
            dif.add(q-len);
            col.add(q);
        }
        for(int i = 0; i < n;i++){    
            ArrayList<String> innertemp = new ArrayList<String>(inner);
            HashSet<Integer> sum1 = new HashSet<Integer>(sum);
            HashSet<Integer> dif1 = new HashSet<Integer>(dif);
            HashSet<Integer> col1 = new HashSet<Integer>(col);
            String temp = createString(i, n);
            innertemp.add(temp);
            helper(innertemp, i, n, sum1, dif1, col1);
        }
    }
    String createString(int q, int n){
        StringBuffer sb = new StringBuffer(n);
        for(int i = 0; i < n; i++){
            if(i== q){
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}

good solution
public class Solution {
    ArrayList<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> inner = new ArrayList<String>();
        helper(inner,0, n);
        return result;
    }
    void helper(ArrayList<String> inner, int q, int n){      
        int len = inner.size()-1;
        if(!check(inner,q)){
            return;
        } else if(len == n-1&&(!inner.isEmpty())){
            result.add(inner);
            return;
        } 
        for(int i = 0; i < n;i++){    
            ArrayList<String> innertemp = new ArrayList<String>(inner);
            String temp = createString(i, n);
            innertemp.add(temp);
            helper(innertemp, i, n);
        }
    }
    String createString(int q, int n){
        StringBuffer sb = new StringBuffer(n);
        for(int i = 0; i < n; i++){
            if(i== q){
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
    private boolean check(ArrayList<String> inner, int q){
    	int len = inner.size()-1;
    	for(int i = 0; i < inner.size()-1; i++){
    		int r = inner.get(i).indexOf("Q");
    		int l = i;
    		if(len+q==r+l||len-q==l-r||q==r){
    			return false;
    		} 
    	}
    	return true;          
    }
}
