public class Solution {
    public int totalNQueens(int n) {
        StringBuffer[] results = new StringBuffer[n];
        StringBuffer sb = new StringBuffer(n);
        ArrayList<Integer> count = new ArrayList<Integer>();
        count.add(0);
        for(int i = 0; i < n; i++){
            sb.append(".");
        }
        for(int i = 0; i < n; i++){
            results[i] = new StringBuffer(sb);
        }
        helper(count, results, -1,0);
        return count.get(0);
    }
    void helper(ArrayList<Integer> count, StringBuffer[] results, int row, int q){
        if(!check(results, row, q)){
            return;
        } else if(row == results.length-1){
            count.set(0,count.get(0)+1);
            return;
        }
        for(int i = 0; i < results.length; i++){
            results[row+1].setCharAt(i, 'Q');
            helper(count, results, row+1, i);
            results[row+1].setCharAt(i, '.');
        }
    }
    private boolean check(StringBuffer[] results,int len, int q){
    	for(int i = 0; i < len; i++){
    		int r = results[i].indexOf("Q");
    		int l = i;
    		if(len+q==r+l||len-q==l-r||q==r){
    			return false;
    		} 
    	}
    	return true;          
    }
}
