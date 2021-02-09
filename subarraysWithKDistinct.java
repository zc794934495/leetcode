class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        //最多有k个不同整数的子数组的个数-最多有k-1个不同整数的子数组的个数=恰好有k个不同整数子数组的个数
        return atMostKDistinct(A,K) - atMostKDistinct(A,K - 1);
    }

    public int atMostKDistinct(int[] A,int K) {
        int len = A.length;
        int[] map = new int[len + 1];
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        while(right < len) {
            //滑动窗口的里没出现过右边界的值
            if(map[A[right]] == 0) {
                count++;
            }
            map[A[right]]++;
            right++;
            //超过k个左边界增加
            while(count > K) {
                map[A[left]]--;
                if(map[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;

    }
}