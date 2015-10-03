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
下面这个代码真是漂亮。
不用flag。
写深度优先的时候要牢记，递归的终止条件，以及什么时候需要递归。
比如这里，越界了是不用判断的。
然后如果当前字符不相等是不用判断的。
在这基础上，如果当前字符相等，是不是就一定要进入下一步判断呢。
如果长度已经到了length - 1了，自然也不用判断了。
这里一开始的写法是用的if (count == length) 然后退出。。
这里其实逻辑不太好，因为我并不是任何情况下都应该进入下一步递归的。。如果当前的相等，然后发现当前的就是最后一位了，
其实就不应该进入下一步递归了。。其实那样写也可以，只是要判断的东西多了一点。。


public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
 
    boolean result = false;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
           if(dfs(board,word,i,j,0)){
               result = true;
           }
        }
    }
 
    return result;
}
 
public boolean dfs(char[][] board, String word, int i, int j, int k){
    int m = board.length;
    int n = board[0].length;
 
    if(i<0 || j<0 || i>=m || j>=n){
        return false;
    }
 
    if(board[i][j] == word.charAt(k)){
        char temp = board[i][j];
        board[i][j]='#';
        if(k==word.length()-1){
            return true;
        }else if(dfs(board, word, i-1, j, k+1)
        ||dfs(board, word, i+1, j, k+1)
        ||dfs(board, word, i, j-1, k+1)
        ||dfs(board, word, i, j+1, k+1)){
            return true;
        }
        board[i][j]=temp;
    }
    
    public class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(i, j, board, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    void helper(int row, int col, char[][] board, String word, int count) {
        if (flag ||(board[row][col] == '*')) {
            return;
        }
        if (board[row][col] != word.charAt(count)) {
            return;
        }
        if (count == word.length() - 1) {
            flag = true;
            return;
        }
            char temp = board[row][col];
            if (row > 0) {
                board[row][col] ='*';
                helper(row - 1, col, board, word, count + 1);
                board[row][col] =temp;
            } 
            if (col > 0) {
                board[row][col] ='*';
                helper(row, col - 1, board, word, count + 1);
                board[row][col] =temp;
            }
            if (row < board.length - 1) {
                board[row][col] ='*';
                helper(row + 1, col, board, word, count + 1);
                board[row][col] =temp;
            }
            if (col < board[row].length - 1) {
                board[row][col] ='*';
                helper(row, col + 1, board, word, count + 1);
                board[row][col] =temp;
            }
    }
}
 
    return false;
}
