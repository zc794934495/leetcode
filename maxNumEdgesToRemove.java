class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int res = 0;
        //将结点编号从0开始，每个结点-1
        for(int[] edge : edges) {
            --edge[1];
            --edge[2];
        }
        //处理公共边
        for(int[] edge : edges) {
            if(edge[0] == 3) {
                //原本就是连通的，则这个边可以删除，即res++
                //否则将alice和bob的这条公共边都连通
                if(!alice.union(edge[1],edge[2])) {
                    res++;
                }else {
                    bob.union(edge[1],edge[2]);
                }
            }
        }
        //处理独占边，连通失败res++
        for(int[] edge : edges) {
            if(edge[0] == 1) {
                if(!alice.union(edge[1],edge[2])) {
                    res++;
                }
            }else if(edge[0] == 2) {
                if(!bob.union(edge[1],edge[2])) {
                    res++;
                }
            }
        }
        //有一个连通分量不为1，说明不满足题意
        if(alice.getCount() != 1 || bob.getCount() != 1) {
            return -1;
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            count = n;
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
            count--;
            return true;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount() {
            return count;
        }
    }
}