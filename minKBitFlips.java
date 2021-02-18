class Solution {
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        //deque存入的数字代表从这个数字开始k个进行了一次翻转
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i < A.length;i++) {
            //队首元素的翻转范围已过
            if(deque.size() > 0 && i > deque.peek() + K - 1) {
                deque.removeFirst();
            }
            /*不需要进行翻转的情况：当前数字为1，已经被翻转偶数次
                                  当前数字为0，已经被翻转奇数次

              需要进行翻转的情况：  当前数字为1，已经被翻转奇数次
                                  当前数字为0，已经被翻转偶数次                  
            */
            if(deque.size() % 2 == A[i]) {
                if(i + K > A.length) {
                    return -1;
                }
                deque.add(i);
                res++;
            }
        }
        return res;
    }
}