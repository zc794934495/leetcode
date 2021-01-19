class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<Edge> edges = new ArrayList<Edge>();
        //将所有边存入edges
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        //对edges的长度升序排序
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge edge1, Edge edge2) {
                return edge1.len - edge2.len;
            }
        });

        int res = 0, num = 1;
        //遍历所有边
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (uf.union(x, y)) {
                //这两个点本身不是连通的，通过并查集连通
                res += len;
                num++;
                //剪枝：当已经连接了n-1条边，所有点都被连通了
                if (num == n) {
                    break;
                }
            }
        }
        return res;
    }
    //计算第x个点和第y个点的曼哈顿距离
    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] < rank[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        rank[rootX] += rank[rootY];
        parent[rootY] = rootX;
        return true;
    }
}

class Edge {
    int len, x, y;

    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}
