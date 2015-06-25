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
second time
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        Boolean[][] check = new Boolean[len][len];
        if(wordDict==null||wordDict.isEmpty())
            return false;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                check[i][j] =false;
            }
        }
        for(int i = 0; i < len; i++){
            check[i][i] = wordDict.contains(s.substring(i,i+1));
        }
        for(int i = 1; i < len; i++){
            for(int j = i; j < len; j++){
                for(int k = j - i; k < j; k++){
                		Boolean a = (wordDict.contains(s.substring(j-i,j+1)));
                		Boolean b = (check[j-i][k]&&check[k+1][j]);
           
                        check[j-i][j] =check[j-i][j]||(wordDict.contains(s.substring(j-i,j+1)))||(check[j-i][k]&&check[k+1][j]);
                }
            }
        }
        return check[0][len-1];
    }
}
