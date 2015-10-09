public class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
    }
}
其实这道题用dp[i]表示结果这里有想到。。
但是一开始很想用Math.pow，然后处理这里的时候有时候加一减一而且还要转换成整数。。没有
想到直接用i * i <= n来做
然后关键是是分解状态的时候，dp[n]首先和dp[n - 1]肯定没有直接关系的。。
可能和dp[n]有关系的是dp[n - i*i],所以这里两层循环几乎是确定了这里。。
记得以前说的，有关系的有时候不止是一种，不能只是从一个状态过来，那就把所有的可能的都遍历一遍把状态找到啊。。
一开始想把它定义成dp[n] = dp[i] + dp[n - i]....哈哈哈哈哈哈。。可是这跟平方数有什么关系。。
每个数的分解如果是依赖两种不定因素的话就应该是三层循环，感觉又是走对角线。。好痛苦，
我们会希望一个dp方程式里面依赖于另一个唯一不定量。。而不是两个。。
然后dp[i + j * j] = = dp[i] + 1
而且dp[n]
