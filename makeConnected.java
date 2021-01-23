class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length + 1) {
            return -1;
        }
        int res = 0;
        UnionFind uf = new UnionFind(n);
        //先将已有边连通
        for(int[] nums : connections) {
            uf.union(nums[0],nums[1]);
        }
        //需要连接多少边
        for(int i = 1;i < n;i++) {
            if(uf.union(0,i)) {
                res++;
            }
        }
        return res;
    }

    private class UnionFind {
        public int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0;i < n;i++) {
                parent[i] = i;
            }
        }

        public boolean union(int x,int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}