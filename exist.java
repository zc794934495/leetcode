class Solution {
    boolean[][] mark;
    int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}}; 
    int m;
    int n;
    String word;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if(m == 0){
            return false;
        }
        n = board[0].length;
        mark = new boolean[m][n];
        this.board = board;
        this.word = word;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int start){
        if(start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if(board[i][j] == word.charAt(start)){
            mark[i][j] = true;
            for(int k = 0;k < 4;k++){
                int x = i + direction[k][0];
                int y = j + direction[k][1];
                if(inArea(x,y) && !mark[x][y]){
                    if(dfs(x,y,start + 1)){
                        return true;  
                    }
                }
            }
            mark[i][j] = false;
        }
        return false;
    }
    public boolean inArea(int x,int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}