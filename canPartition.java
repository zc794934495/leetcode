class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        //求和
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //数组总和为奇数
        if((sum & 1) == 1){
            return false;
        }
        int target;
        target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        //初始化第一列为true，可以将nums[i]等于j(即j - nums[i]等于0)归到nums[i] < j中一起赋值
        dp[0] = true;
        //初始化第一行，
        if(nums[0] <= target){
            dp[0] = true;
        }
        for(int i = 1;i < len;++i){
            for(int j = target;nums[i] <= j;--j){
                //最后一列一旦为true，下面的值都为true，不需要继续填表
                if(dp[target] == true){
                    return true;
                }
                //上一行的值(不选择nums[i])，这一行减去nums[i]的值（选择nums[i]）
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}