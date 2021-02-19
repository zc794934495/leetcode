class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int len = A.length;
        int count = 0;
        int res = 0;
        while(right < len) {
            //记录窗口内0的个数
            if(A[right] != 1) {
                count++;
            }
            //0的个数大于k左边界右移
            while(count > K) {
                if(A[left++] == 0) {
                    count--;
                }
            }
            res = Math.max(res,right - left + 1);
            right++;
        }
        return res;
    }
}