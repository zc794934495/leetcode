class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        //填充为最大值（因为可能会加1导致越界，所以减1）
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1;i < T + 1;i++) {
            for(int[] nums : clips) {
                //找到可以覆盖[nums[0],i]的片段
                if(nums[0] < i && nums[1] >= i) {
                    dp[i] = Math.min(dp[i],dp[nums[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}