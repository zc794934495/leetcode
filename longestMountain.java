class Solution {
    public int longestMountain(int[] A) {
        int len = A.length;
        int left = 0;
        int ans = 0;
        //循环到left为倒数第三个为止
        while(left + 2 < len) {
            int right = left + 1;
            //判断上山
            if(A[left] < A[left + 1]) {
                //一直判断是否继续上山
                while(right + 1 < len && A[right] < A[right + 1]) {
                    right++;
                }
                //判断接下来是否下山
                if(right + 1 < len && A[right] > A[right + 1]) {
                    while(right + 1 < len && A[right] > A[right + 1]) {
                        right++;
                    }
                    ans = Math.max(ans,right - left + 1);
                }else {
                    right++;
                }
            }
            left = right;
        }
        return ans;
    }
}