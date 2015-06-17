public class Solution {
    ArrayList<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        StringBuffer sb = new StringBuffer();
        String[] ary = new String[s.length()];
        for(int i = 0; i < s.length(); i++){
        	ary[i] = s.charAt(i)+"";
        }
        if(s.length()>12){
            return result;
        }
        helper(0, sb, ary, 0);
        return result;
    }
    void helper(int cur, StringBuffer sb, String[] right, int count){
        if(sb.length()>0&&sb.charAt(sb.length()-1)!='.'&&(getInt(sb)>255||getInt(sb)==-1)){
            return;
        }
        if(count==3&&cur==right.length){
               result.add(sb.toString());
               return;
        }
        if(cur==right.length){
            return;
        }
        StringBuffer temp = new StringBuffer(sb);
        temp.append(right[cur]);
        helper(cur+1, temp, right, count);
        
        if(sb.length()>0&&sb.charAt(sb.length()-1)!='.'){
            StringBuffer temp1 = new StringBuffer(sb);
            temp1.append(".");
            helper(cur,temp1,right, count+1);
        }
    }
    int getInt(StringBuffer sb){
    	int index = sb.lastIndexOf(".")+1;
    	String temp=sb.substring(index);
    	if(temp.length()>1&&temp.charAt(0)=='0'){
    	    return -1;
    	}
        return Integer.parseInt(temp);
    }

}
