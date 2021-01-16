class Solution {
    private int rows;
    private int cols;

    public static final int[][] DIRECTIONS = {{0,1},{1,0},{-1,0},{0,-1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        //复制一个grid数组
        int[][] copy = new int[rows][cols];
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                copy[i][j] = grid[i][j];
            }
        }
        //先把copy中的hits全部击碎
        int hitslen = hits.length;
        for(int i = 0;i < hitslen;i++) {
            copy[hits[i][0]][hits[i][1]] = 0;
        }
        //代表屋顶
        int size = rows * cols;
        UnionFind uf = new UnionFind(size + 1);
        //将第0行的砖块与屋顶相连
        for(int j = 0;j < cols;j++) {
            if(copy[0][j] == 1) {
                uf.union(j,size);
            }
        }
        //其他行的砖块，如果左，上方向也是砖块则合并
        for(int i = 1;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(copy[i][j] == 1) {
                    //上边是砖块
                    if(copy[i - 1][j] == 1) {
                        uf.union(getIndex(i - 1,j),getIndex(i,j));
                    }
                    //左边是砖块
                    if(j > 0 && copy[i][j - 1] == 1) {
                        uf.union(getIndex(i,j - 1),getIndex(i,j));
                    }
                }
            }
        }
        //结果数组
        int[] res = new int[hitslen];
        //逆序补上砖块，看有多少砖块会因为补上这个砖块而与屋顶相连
        for(int i = hitslen - 1;i >= 0;i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            //消除的是没有砖块的空白位置
            if(grid[x][y] == 0) {
                continue;
            }
            //计算当前hits没有被补上时，与屋顶相连的砖块数
            int origin = uf.getSize(size);
            //如果补上的砖块是第0行的，补上的砖块与屋顶相连
            if(x == 0) {
                uf.union(y,size);
            }
            //检查上下左右，如果有砖块则合并
            for(int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if(inArea(newX,newY) && copy[newX][newY] == 1) {
                    uf.union(getIndex(x,y),getIndex(newX,newY));
                }
            }
            //计算补上当前砖块后，与屋顶相连的砖块数
            int current = uf.getSize(size);
            //返回差值，减去的1是补回的砖块
            res[i] = Math.max(0,current - origin - 1);
            //将砖块补回
            copy[x][y] = 1;
        }
        return res;
    }
    //判断坐标是否出界
    private boolean inArea(int x,int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }
    //将二维坐标转换为一维坐标
    private int getIndex(int x,int y) {
        return x * cols + y;
    }
    
    private class UnionFind {

        private int[] parent;
        //以当前节点为根节点的子树的节点总数
        private int[] size;
        
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0;i < n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x,int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }

}