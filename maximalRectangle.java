class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        //nums[i][j]表示matrix左边（包括自己）有多少个连续的1
        int[][] nums = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(matrix[i][j] == '1') {
                    //第一列初始化为初始化为1，其他列为前一列加一
                    nums[i][j] = (j == 0 ? 1 : nums[i][j - 1] + 1);
                }
            }
        }
        int res = 0;
        //遍历matrix,找以matrix[i][j]为右下角的只包含1的最大矩阵
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                //不存在matrix为右下角的只包含1的矩阵
                if(matrix[i][j] == '0') {
                    continue;
                }
                //该矩阵的宽
                int width = nums[i][j];
                //初始高度为1，area=width*1
                int area = width;
                for(int k = i - 1;k >= 0;k--) {
                    //宽度为0，不需要再向上找
                    if(width == 0) {
                        break;
                    }
                    width = Math.min(width,nums[k][j]);
                    area = Math.max(area,width * (i - k + 1));
                }
                res = Math.max(res,area);
            }
        }
        return res;
    }
}