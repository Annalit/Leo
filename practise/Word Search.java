//https://leetcode.com/problems/word-search/
/**
 *@author annabel
 *@since  4.18.2015
 */
public class Solution {
    Boolean result = false;

    public boolean exist(char[][] board, String word) {
        StringBuffer sb = new StringBuffer();
        if(board.length == 1 && board[0].length ==1){// corner case
        	if(word.equals(board[0][0]+"")){
        		return true;
        	}
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(sb, board, word, i, j);
                if (result == true){
                    break;
                }
            }
        }
        return result;

    }

    void helper(StringBuffer sb, char[][] tb, String word, int row, int col){ 
        if(this.result == true){ // how to stop searching:1. class variable 2. paramter . put them at the first
            return;
        }
        if (word.equals(sb.toString())) {// put the true condition at the second
            result = true;
            return;
        }
        
    	if (sb.length() >= word.length()) {//put the false condition at the third
            return;
        }
    	/*how to decide whether duplicate?
    	^ ^especially in the [][] 
    	lot of things can help to record the location!  
    	You can't use anther check[][]here because each time you change it, when you end a stack, how can it go back?
    	maybe you could, but it is not the best way.
    	use the # in the element of the [][]
    	don't forget to return it!
    	*/
        if (word.charAt(sb.length()) != tb[row][col]) {
            return;
        }
        
        if (tb[row][col] == '#') {
            return;
        }
        // you only need to return to the original when there is really no way to go!!!!
        // so see the better solution below!
        if (row > 0) {
            StringBuffer temp1 = new StringBuffer(sb);
            temp1.append(tb[row][col]);
            char keep = tb[row][col];
            tb[row][col] = '#';
            helper(temp1, tb, word, row - 1, col);
            tb[row][col]=keep;
        }

        if (col > 0) {
            StringBuffer temp2 = new StringBuffer(sb);
            temp2.append(tb[row][col]);
            char keep = tb[row][col];
            tb[row][col] = '#';
            helper(temp2, tb, word, row, col - 1);
            tb[row][col]=keep;
        }
        if (row < tb.length - 1) {
            StringBuffer temp3 = new StringBuffer(sb);
            temp3.append(tb[row][col]);
            char keep = tb[row][col];
            tb[row][col] = '#';
            helper(temp3, tb, word, row + 1, col);
            tb[row][col]=keep;
        }
        if (col < tb[0].length - 1) {
            StringBuffer temp4 = new StringBuffer(sb);
            temp4.append(tb[row][col]);
            char keep = tb[row][col];
            tb[row][col] = '#';
            helper(temp4, tb, word, row, col + 1);
            tb[row][col]=keep;
        }
    }
}
// better solution!
public class Solution {
    Boolean result = false;

    public boolean exist(char[][] board, String word) {
        StringBuffer sb = new StringBuffer();
        if(board.length == 1 && board[0].length ==1){// corner case
        	if(word.equals(board[0][0]+"")){
        		return true;
        	}
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(sb, board, word, i, j);
                if (result == true){
                    break;
                }
            }
        }
        return result;

    }

    void helper(StringBuffer sb, char[][] tb, String word, int row, int col){ 
        if(this.result == true){ // how to stop searching:1. class variable 2. paramter . put them at the first
            return;
        }
        if (word.equals(sb.toString())) {// put the true condition at the second
            result = true;
            return;
        }
        
    	if (sb.length() >= word.length()) {//put the false condition at the third
            return;
        }
    
        if (word.charAt(sb.length()) != tb[row][col]) {
            return;
        }
        
        if (tb[row][col] == '#') {
            return;
        }
        char keep = tb[row][col];
        if (row > 0) {
            StringBuffer temp1 = new StringBuffer(sb);
            temp1.append(tb[row][col]);
            tb[row][col] = '#';
            helper(temp1, tb, word, row - 1, col);
        }

        if (col > 0) {
            StringBuffer temp2 = new StringBuffer(sb);
            temp2.append(tb[row][col]);
            char keep = tb[row][col];
            helper(temp2, tb, word, row, col - 1);
        }
        if (row < tb.length - 1) {
            StringBuffer temp3 = new StringBuffer(sb);
            temp3.append(tb[row][col]);
            tb[row][col] = '#';
            helper(temp3, tb, word, row + 1, col);
        }
        if (col < tb[0].length - 1) {
            StringBuffer temp4 = new StringBuffer(sb);
            temp4.append(tb[row][col]);
            tb[row][col] = '#';
            helper(temp4, tb, word, row, col + 1);
        }
            tb[row][col]=keep;// you only need to return to the original when there is really no way to go!!!!
    }
}
