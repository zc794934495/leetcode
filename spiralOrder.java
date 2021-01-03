class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        int j = 0;
        int i = 0;
        List<Integer> res = new ArrayList<>();
        //循环一次为一圈
        while(true) {
            int count = 0;
            //向右走到底
            while(j + 1 < n && used[i][j + 1] == false) {
                res.add(matrix[i][j]);
                used[i][j] = true;
                count++;
                j++;
            }
            //向下走到底
            while(i + 1 < m && used[i + 1][j] == false) {
                res.add(matrix[i][j]);
                used[i][j] = true;
                count++;
                i++;
            }
            // 向左走到底
            while(j - 1 >= 0 && used[i][j - 1] == false) {
                res.add(matrix[i][j]);
                used[i][j] = true;
                count++;
                j--;
            }
            //向上走到底
            while(i - 1 >= 0 && used[i - 1][j] == false){
                res.add(matrix[i][j]);
                used[i][j] = true;
                count++;
                i--;
            }
            //本次循环没有任何操作，说明已经遍历完
            if(count == 0) {
                break;
            }  
        }
        //加上最后一个无路可走的数
        res.add(matrix[i][j]);
        return res;
    }
}