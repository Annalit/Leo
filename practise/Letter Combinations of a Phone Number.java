https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution{
    List<String> result = new ArrayList<String>();
    public List<String> letterCombinations(String digits){
        if(digits.length() == 0){
            return result;
        }
        String[] save = new String[8];//2,3,4,5,6,7,8,9
        save[0] = "abc";
        save[1] = "def";
        save[2] = "ghi";
        save[3] = "jkl";
        save[4] = "mno";
        save[5] = "pqrs";
        save[6] = "tuv";
        save[7] = "wxyz";
        String[] cur = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            cur[i] = save[Integer.parseInt(""+digits.charAt(i))-2];//how to change the char to String?
        }
        StringBuffer sb = new StringBuffer();
        helper(cur, sb, digits.length());
        return result;
    }
    void helper(String[] cur, StringBuffer sb, int len){
        //when to return and add to result
        if(sb.length() == len){//when you find that the condition should be related to a fixed number, you should add 
        //the fixed number to the parameter
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i < cur.length; i++){
            for(int j = 0; j < cur[i].length(); j++){// good job here!
                StringBuffer temp = new StringBuffer(sb);
                temp.append(cur[i].charAt(j));
                //right = cur i+1
                String[] right = Arrays.copyOfRange(cur, i+1, cur.length);//copyOfRange!!!!!
                helper(right, temp, len);
            }
        }
    }
}
