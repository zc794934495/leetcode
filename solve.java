class Solution {
    int m,n;
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0){
            return;
        }
        n = board[0].length;
        for(int i = 0;i < m;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if(board[i][n - 1] == 'O'){
                dfs(i,n - 1,board);
            } 
        }
        for(int j = 1;j < n - 1;j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board);
            }
            if(board[m - 1][j] == 'O'){
                dfs(m - 1,j,board);
            } 
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'X'){
                    continue;
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board){
       if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O'){
           return;
       }
       board[i][j] = 'M';
       dfs(i - 1,j,board);
       dfs(i,j + 1,board);
       dfs(i + 1,j,board);
       dfs(i,j - 1,board);
    }
}