class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int len = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < len) {
            //维护最大值单调递减
            while(!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            //维护最小值单调递增
            while(!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            //右边界需要移动
            while(!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                //判断右边界对当前最大值最小值的影响
                if(queMin.peekFirst() == nums[left]) {
                    queMin.pollFirst();
                }
                if(queMax.peekFirst() == nums[left]) {
                    queMax.pollFirst();
                }
                left++;
            }
            res = Math.max(res,right - left + 1);
            right++;
        }
        return res;

    }
}