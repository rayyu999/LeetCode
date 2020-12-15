package dfs;

public class JZOffer12 {

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        // 枚举起点
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                if (dfs(board, word, 0, r, c)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int cnt, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (board[r][c] == '-' || word.charAt(cnt) != board[r][c]) return false;
        // 将当前位置标记，避免重复访问
        char tmp = board[r][c];
        board[r][c] = '-';
        // 若已访问了字符串的所有字符，返回true
        if (cnt == word.length() - 1) return true;
        // 否则继续向四个方向寻找
        boolean res = dfs(board, word, cnt+1, r+1, c)
                || dfs(board, word, cnt+1, r-1, c)
                || dfs(board, word, cnt+1, r, c+1)
                || dfs(board, word, cnt+1, r, c-1);
        // 将当前位置取消标记，返回上一层递归
        board[r][c] = tmp;
        return res;
    }

}
