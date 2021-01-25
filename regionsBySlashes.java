class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        //一个单元格分为四个
        int size = 4*n*n;
        UnionFind uf = new UnionFind(size);
        for(int i = 0;i < n;i++) {
            char[] row = grid[i].toCharArray();
            for(int j = 0;j < n;j++) {
                //二维数组转为一维数组
                int index = 4 * (i * n + j);
                char c = row[j];
                
                if(c == '/') { //单元格内上左合并，右下合并
                    uf.union(index,index + 3);
                    uf.union(index + 1,index + 2);
                }else if(c == '\\') { //单元格内上右合并，左下合并
                    uf.union(index,index + 1);
                    uf.union(index + 2,index + 3);
                }else { //单元格内上下左右合并
                    uf.union(index,index + 1);
                    uf.union(index + 1,index + 2);
                    uf.union(index + 2,index + 3);
                }
                //单元格间当前单元格右和下一个单元格左合并
                if(j + 1 < n) {
                    uf.union(index + 1,4*(i * n + (j + 1)) + 3);
                }
                //单元格间当前单元格下和下一个单元格上合并
                if(i + 1 < n) {
                    uf.union(index + 2,4 * ((i + 1) * n + j));
                }
            }
        }
        return uf.getCount();

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

        public void union(int x,int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
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