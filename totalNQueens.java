class Solution {
    int res = 0;
    int n;
    Set<Integer> col;
    Set<Integer> sub;
    Set<Integer> main;
    public int totalNQueens(int n) {
        this.n = n;
        if(n == 0){
            return res;
        }
        col = new HashSet<>();
        sub = new HashSet<>();
        main = new HashSet<>();
        dfs(0);
        return res;
    }
    public void dfs(int row){
        if(row == n){
            res = res + 1;
            return;
        }
        for(int i = 0;i < n;i++){
            if(!col.contains(i) && !sub.contains(row + i) && !main.contains(row - i)){
                col.add(i);
                sub.add(row + i);
                main.add(row - i);
                dfs(row + 1);
                main.remove(row - i);
                sub.remove(row + i);
                col.remove(i);
            }
        }
    }
}