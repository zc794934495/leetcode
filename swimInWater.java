class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        minHeap.offer(new int[]{0,0});

        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];
        for(int[] row : dist) {
            Arrays.fill(row,n * n);
        }
        dist[0][0] = grid[0][0];

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int x = front[0];
            int y = front[1];
            
            if(visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if(x == n - 1 && y == n - 1) {
                return dist[n - 1][n - 1];
            }

            for(int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(newX >= 0 && newX < n && newY >= 0 && newY < n && Math.max(dist[x][y],grid[newX][newY]) < dist[newX][newY]) {
                    dist[newX][newY] = Math.max(dist[x][y],grid[newX][newY]);
                    minHeap.offer(new int[]{newX,newY});
                }
            }
        }
        return -1;
    }
}