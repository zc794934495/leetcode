class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length - 1;
        for(int i = len;i > 0;i--) {
            if(nums[i] > nums[i - 1]) { //找到非降序的nums[i]
                for(int j = len;j > i - 1;j--) {
                    if(nums[j] > nums[i - 1]) { //找到第一个大于nums[i]的nums[j]
                        swap(nums,j,i - 1);//交换位置
                        reverse(nums,i,len);//翻转nums[i - 1]之后的元素
                        return;
                    }
                }
            }
        }
        //说明不存在下一个更大的排列，翻转数组变为最小排列
        reverse(nums,0,len);
    }
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums,int left,int right) {
        while(left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}