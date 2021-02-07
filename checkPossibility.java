class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length - 1;i++) {
            if(nums[i] > nums[i + 1]) {
                count++;
                if(count > 1) {
                    return false;
                }
                //i-1 > i+1 则 i+1变为i 例如:3 4 2 3
                if(i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}