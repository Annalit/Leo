public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] res = new int[length1+1][length2+1];
        
        for(int i = 0; i <= length1; i++) 
            res[i][0] = i;
        for(int j = 0; j <= length2; j++)
            res[0][j] = j;
    
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(word1.charAt(i-1)!= word2.charAt(j-1)){
                    res[i][j] = Math.min(res[i-1][j-1]+1,Math.min(res[i-1][j]+1, res[i][j-1]+1));
                } else {
                    res[i][j] = res[i-1][j-1];
                }
            }
        }
        return res[length1][length2];
    }
}
https://www.youtube.com/watch?v=9mod_xRB-O0
