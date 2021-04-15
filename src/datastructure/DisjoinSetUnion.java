package datastructure;

import java.util.Arrays;

/**
 * 并查集
 */
public class DisjoinSetUnion {

    public int n;  // 并查集长度
    public int[] rank; // 节点等级
    public int[] f;    // 存储对应的祖先节点

    // 构造函数，初始化属性
    public DisjoinSetUnion(int n) {
        this.n = n;
        rank = new int[n];
        Arrays.fill(rank, 1);
        f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
        }
    }

    // 寻找节点祖先
    public int find(int x) {
        return f[x] == x ? x : find(f[x]);
    }

    // 合并并查集
    public void merge(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy)
            return;
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
    }

}
