package dfs;

public class No547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n < 2) return n;
        boolean[] isVisited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            ++res;
            for (int j = i+1; j < n; ++j) {
                if (isConnected[i][j] == 1)
                    dfs(j, isConnected, isVisited);
            }
        }
        return res;
    }

    private void dfs(int index, int[][] isConnected, boolean[] isVisited) {
        for (int i = 0; i < isConnected.length; ++i) {
            if (!isVisited[i] && isConnected[index][i] == 1) {
                isVisited[i] = true;
                dfs(i, isConnected, isVisited);
            }
        }
    }

}
