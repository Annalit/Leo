public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int l = 0;
        int k = 0;
        if(m == 0 && n == 0){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        } else{
            obstacleGrid[0][0] =1;
        }
        for(int i = 1; i < m; i++){
            if(l > 0){
                obstacleGrid[i][0] = 0;
                continue;
            } else if(obstacleGrid[i][0]==1){
                obstacleGrid[i][0] = 0;
                l = i;
            } else{
                obstacleGrid[i][0] = 1;
            }
        }
        
        for(int i = 1; i < n; i++){
            if(k > 0){
                obstacleGrid[0][i] = 0;
                continue;
            } else if(obstacleGrid[0][i]==1){
                obstacleGrid[0][i] = 0;
                k = i;
            } else{
                obstacleGrid[0][i] = 1;
            }
        }
            
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
