class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for(int[] edge : edges) {
            //返回根连通的边
            if(!uf.union(edge[0],edge[1])) {
                return edge;
            }
        }
        return null;
    }

    public static class UnionFind {
        int[] parent;

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