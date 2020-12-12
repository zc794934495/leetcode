class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int count = 1;
        //flag = 1代表需要找上升，flag = -1代表需要找下降
        int flag = 0; //flag = 0代表初始可以是上升可以是下降
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > nums[i - 1] && flag != 1) {
                flag = 1;
                count++;
            }
            if(nums[i] < nums[i - 1] && flag != -1) {
                flag = -1;
                count++;
            }
        }
        return count;
    }
}