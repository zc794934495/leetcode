class Solution {
    int m, n, k;
    boolean[][] used;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.used = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || used[i][j])  { 
            return 0;
        }
        used[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}
