class Solution {
    // public List<Integer> addToArrayForm(int[] A, int K) {
    //     List<Integer> res = new LinkedList<>();
    //     int n = A.length;
    //     for(int i = n - 1;i >= 0;i--) {
    //         int sum = A[i] + K % 10;
    //         K /= 10;
    //         if(sum >= 10) {
    //             K++;
    //             sum -= 10;
    //         }
    //         res.add(sum);
    //     }
    //     for(;K > 0;K /= 10) {
    //         res.add(K%10);
    //     }
    //     Collections.reverse(res);
    //     return res;
    // }
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                //A[i]与k相加
                K += A[i];
            }
            //只保留个位，其余位都当做进位
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}