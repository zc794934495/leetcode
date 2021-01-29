class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        //到达x坐标，y坐标，花费的最小体力值
        pq.offer(new int[]{0, 0, 0});
        //二维坐标转位一维，（m - 1）* n + n - 1 == m * n - 1
        int[] dist = new int[m * n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] seen = new boolean[m * n];

        while (!pq.isEmpty()) {
            //每次选出最小体力值的来走
            int[] edge = pq.poll();
            int x = edge[0], y = edge[1], d = edge[2];
            int id = x * n + y;
            //代表这个节点走过了
            if (seen[id]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                break;
            }
            seen[id] = true;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                //不越界并且高度差小于新坐标的dist
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && Math.max(d, Math.abs(heights[x][y] - heights[nx][ny])) < dist[nx * n + ny]) {
                    dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                    pq.offer(new int[]{nx, ny, dist[nx * n + ny]});
                }
            }
        }
        
        return dist[m * n - 1];
    }
}