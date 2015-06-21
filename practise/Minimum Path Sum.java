public class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        if(r == 0){
            return 0;
        }
        int l = grid[0].length;
        int[][] res = new int[r][l];
        res[0][0] = grid[0][0];
        for(int i = 1; i < r; i++){
            res[i][0] = res[i-1][0]+grid[i][0];
        }
        for(int i = 1; i < l; i++){
            res[0][i] = res[0][i-1]+grid[0][i];
        }
        for(int i = 1; i < r; i++){
            for(int j = 1; j < l; j++){
                res[i][j] = Math.min(res[i-1][j]+grid[i][j], res[i][j-1]+grid[i][j]);
            }
        }
        return res[r-1][l-1];
    }
}
