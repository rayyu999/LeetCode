package dbfs;

public class JZOffer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    public int dfs(int r, int c, int m, int n, int k, boolean[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || r/10 + r%10 + c/10 + c%10 > k) return 0;
        visited[r][c] = true;
        return dfs(r + 1, c, m, n, k, visited) + dfs(r, c + 1, m, n, k, visited) + 1;
    }

}
