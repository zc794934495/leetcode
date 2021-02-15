class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != 1) {
                res = Math.max(count,res);
                count = 0;
            }else {
                count++;
            }
            
        }
        res = Math.max(count,res);
        return res;
    }
}