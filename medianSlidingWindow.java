class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new double[0];
        }
        int n = nums.length;
        double[] result = new double[n - k + 1];
        int index=0;
        //存储较小一半数的大根堆
        PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        //存储较大一半数的小根堆
        PriorityQueue<Integer> large = new PriorityQueue<>();
        int left=0,right=0;
        boolean isOdd = k % 2 == 1;
        while (right < n) {
            //窗口大小到达k时，每移入一个元素要移出左边元素
            if (right - left >= k) {
                if (nums[left] <= small.peek()) {
                    small.remove(nums[left]);
                } else {
                    large.remove(nums[left]);
                }
                left++;
            }
            //右边元素入堆
            if (small.size() <= large.size()) {
                large.offer(nums[right]);
                small.offer(large.poll());
            } else {
                small.offer(nums[right]);
                large.offer(small.poll());
            }

            //从堆顶获取中位数
            if (right - left == k - 1) {
                if (isOdd) {//窗口长度是奇数，中位数是元素数量较多那个堆的堆顶
                    result[index++] = (double) (small.size() > large.size() ? small.peek() : large.peek());
                } else {//窗口长度是偶数，中位数是两个堆顶均值
                    result[index++] = ((double)small.peek() + (double)large.peek()) / 2d;
                }
            }
            right++;
        }
        return result;
    }
}