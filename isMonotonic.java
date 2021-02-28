class Solution {
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for(int i = 1;i < A.length;i++) {
            if(A[i] - A[i - 1] > 0) {
                inc = false;
            }
            if(A[i] - A[i - 1] < 0) {
                dec = false;
            }
        }
        return inc || dec;
    }
}