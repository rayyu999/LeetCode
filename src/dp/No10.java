package dp;

/**
 * @Author Ray
 * @Date 2021/6/23 22:42
 * @Description 10.正则表达式匹配
 */
public class No10 {

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        // 初始状态
        dp[0][0] = true;
        for (int i = 2; i <= m; ++i) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    // 当前字符匹配得上
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*' && j >= 2) {
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') {
                        // 直接忽略最后两个字符（匹配0个p[j-1]）
                        dp[i][j] = dp[i][j-2];
                    } else {
                        // 查看前面的子串是否匹配
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[n][m];
    }

}
