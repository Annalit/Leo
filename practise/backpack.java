还是有初始化的版本最舒服了。。
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        // define: dp[i][j] means the max size we can fill in the size j backpack from the the first i items.
        //dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i],dp[i - 1][j]) 
        //if backpack size < A[0], is 0
        //
        int max = -1;
        int[][] dp = new int[A.length][m + 1]; 
        for (int i = 0; i < m; i++) {
            if (A[0] < i) {
                dp[0][i] = A[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j >= A[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i],dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        // define: dp[i][j] means the max size we can fill in the size j backpack from the the first i items.
        //dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i],dp[i - 1][j]) 
        //if backpack size < A[0], is 0
        //
        int max = -1;
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + A[i - 1],dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}

这题一开始new一个数组并没有大一号，然后出了问题，如下。
在这里你会发现根本就没有用到第0个物品。
dp[0][1] dp[0][2]的定义会发现其实是非常麻烦的，所以这里干脆就全部设置为0
dp[i][j]的意思是从第0个物品到第i- 1个物品
        int[][] dp = new int[A.length][m + 1];
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j >= A[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i],dp[i - 1][j]);
                    如果我将dp[i][j]定义为0 -- i，书包容量是j，那么它有两种递推可能，一种是第i个不要，也就是dp[i - 1][j]，
                    一种是第i个要，如果j 比当前的i大，dp[i - 1][j - A[i]] + A[i],但是i是从0开始的话。。i - 1就不对了，如果i是从
                    1开始的话，A[i]就不对了。。如果定义为 1 - i，
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
