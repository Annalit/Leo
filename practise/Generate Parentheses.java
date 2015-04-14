//https://leetcode.com/problems/generate-parentheses/
public class Solution{
    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n){
        StringBuffer sb = new StringBuffer();
        helper(sb,n,n);
        return result;
    }
    void helper(StringBuffer sb, int left, int right){
        if(left > right||left < 0|| right < 0){
            return;
        }
        if(left == 0 && right == 0){
            result.add(sb.toString());
            return;
        }
        //the nature of the for loop is to control the choice of the result..
        //write the way of[((()))]and use for loop.
        if(left>=0){
            StringBuffer temp1 = new StringBuffer(sb);
            temp1.append("(");
            int lefttemp = left-1;
            helper(temp1, lefttemp, right);
        }
        if(right>=0){
            StringBuffer temp2 = new StringBuffer(sb);
            temp2.append(")");
            int righttemp = right-1;
            helper(temp2, left, righttemp);
        }
    }
}
