class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        UnionFind uf = new UnionFind(len);
        for(int i = 0;i < len;i++) {
            for(int j = i + 1;j < len;j++) {
                if(isSimilar(strs[i],strs[j])) {
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }
    //判断是否相似
    public boolean isSimilar(String str1,String str2) {
        int n = str1.length();
        int count = 0;
        for(int i = 0;i < n;i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            //有两个以上不想等位置则不相似
            if(count > 2) {
                return false;
            }
        }
        return true;
    }

    private class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
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