class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        //行翻转，让每一行第0列都为1，并乘以第一列的权值
        int res = m * (1 << (n - 1)); 
        for(int j = 1;j < n;j++) {
            int sum = 0;
            for(int i = 0;i < m;i++) {
                if(A[i][0] == 1) { //没有被行翻转
                    sum += A[i][j];
                }else { //被行翻转
                    sum += A[i][j]^1;
                }
            }
            //比较这一列需不需要翻转，再乘以这一列的权值
            res += Math.max(sum,m - sum) * (1 << (n - j - 1));
        }
        return res;
    }
}