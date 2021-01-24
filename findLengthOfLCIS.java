class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        //初始值为1
        int count = 1;
        int res = 0;
        for(int i = 1;i < nums.length;i++) {
            if(nums[i - 1] >= nums[i]) {
                if(count > res) {
                    res = count;
                }
                //重置count
                count = 0;
            }
            count++;
        }
        if(count > res) {
            res = count;
        }
        return res;
    }
}