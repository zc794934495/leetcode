class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums,0,n - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,n - 1);
    }

    public void reverse(int[] nums,int start,int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int start = 0;
        while (start < nums.length && k != 0) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
            //前k个数已经在对应位置上，问题变为对后n - k个数循环移动k次
            n -= k;
            start += k;
            k %= n;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}