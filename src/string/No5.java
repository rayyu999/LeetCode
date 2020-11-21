package string;

public class No5 {

    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 0, start = 0;
        boolean[][] dp = new boolean[n][n];

        // 枚举子串长度
        for (int len = 0; len < n; ++len) {
            // 枚举起始位置
            for (int i = 0; i < n - len; ++i) {
                int j = i + len;    // 判断子串首尾字符是否相等

                /*
                    当:
                    1. 子串只有单个字符
                    2. 子串首尾字符相同且子串只有两个字符
                    3. 子串首尾相同且撇除首尾字符后的子串依旧为回文串
                    时，当前子串也为回文串
                */
                if (i == j || (s.charAt(i) == s.charAt(j) && (len == 1 || dp[i+1][j-1]))) {
                    dp[i][j] = true;
                    if (len + 1 > maxLen) {
                        maxLen = len + 1;   // 更新最长子串长度
                        start = i;  // 记录最长子串的起始下标
                    }
                }
            }
        }
        return maxLen > 0 ? s.substring(start, start + maxLen) : "";
    }

}
