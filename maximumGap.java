class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        //基数排序
        int max = nums[0];
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        int maxLen = (max + "" ).length();
        int[][] bucket = new int[10][nums.length];

        int a = 1;
        while(maxLen > 0) {
            int[] count = new int[10];
            for(int num : nums) {
                int bits = num / a % 10;
                bucket[bits][count[bits]] = num;
                count[bits]++;
            }
            int index = 0;
            for(int i = 0;i < 10;i++) {
                if(count[i] != 0) {
                    for(int j = 0;j < count[i];j++) {
                        nums[index++] = bucket[i][j];
                    }
                }
            }
            a *= 10;
            maxLen--;
        }
        //求差值最大
        int maxDiff = 0;
        for(int i = 1;i < nums.length;i++) {
            if(maxDiff < nums[i] - nums[i - 1]) {
                maxDiff = nums[i] - nums[i -1];
            }
        }
        return maxDiff;
    }
}