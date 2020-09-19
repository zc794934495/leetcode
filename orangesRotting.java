class Solution {
    int[] dr = new int[]{-1,0,1,0}; //上下左右行的变化
    int[] dc = new int[]{0,-1,0,1}; //上下左右列的变化
    public int orangesRotting(int[][] grid) {
        int R = grid.length;      //行数
        int C = grid[0].length;    //列数
        Queue<Integer> queue = new ArrayDeque();   //存储腐烂的橘子
        Map<Integer,Integer> depth = new HashMap();
        for(int r = 0;r < R;++r){
            for(int c = 0;c < C;++c){
                if(grid[r][c] == 2){
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code,0);
                }
            }
        }

        int ans = 0;
        while(!queue.isEmpty()){
            int code = queue.remove();
            int r = code / C;
            int c = code % C;
            for(int k = 0;k < 4;++k){
                int nr = r + dr[k];
                int nc = c + dc[k];
                //上下左右有橘子并且是新鲜橘子
                if(0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1 ){
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode,depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }

        }
        for(int[] row : grid){
            for(int v : row){
                if(v == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}