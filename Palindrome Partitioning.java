//https://leetcode.com/problems/palindrome-partitioning/
public class Solution{
    List<List<String>> result = new ArrayList<List<String>>(); 
    public List<List<String>> partition(String s){
        List<String> inner = new ArrayList<String>();
        helper(inner, s);
        return result;
    }
    void helper(List<String> inner, String s){
        if(s.length() == 0){//still two parts
            result.add(inner);
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s.substring(0,i+1))){//when to add to the List<>, any condition?
                List<String> temp = new ArrayList<String>(inner);
                temp.add(s.substring(0,i+1));//how/which part to add to the List<>
                // for this String problem, no need to think the String changes, what really changes is the pointer.
                helper(temp, s.substring(i+1));//after added, go the the next          
            }
        }
    }
    Boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
