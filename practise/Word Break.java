TLE
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict == null||wordDict.isEmpty()){
            return false;
        }
        return check(0, s.length()-1,s,wordDict);
    }
        Boolean check(int l, int h, String s, Set<String> word){
            if(word.contains(s)){
                return true;
            }
            if(l>=h||s == null||s.length() == 0){
                return false;
            }
            for(int i = l; i <= h; i++){
                String s1 = s.substring(l,i);
                String s2= s.substring(i,h+1);
                if(check(0,s1.length()-1,s1,word)&&check(0,s2.length()-1,s2,word)){
                    return true;
                }
            }
            return false;
        }
}
