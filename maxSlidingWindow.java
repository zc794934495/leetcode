class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        //存入k个数字和对应下标
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            //存入下一个数和对应下标
            pq.offer(new int[]{nums[i], i});
            //poll出不在当前滑动窗口，并且是当前大顶堆的最大值
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}

