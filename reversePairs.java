class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return mergeSort(nums,0,nums.length - 1);
    }
    public int mergeSort(int[] nums,int left,int right) {
        if(left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int count = mergeSort(nums,left,mid) + mergeSort(nums,mid + 1,right);

        //统计重要翻转对个数
        int i = left;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += j - mid - 1;
            i++;
        }
        merge(nums,left,mid,right);
        return count;
    }
    //合并
    public void merge(int[] nums,int left,int mid,int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            }else {
                temp[index++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[index++] = nums[i++];
        }
        while(j <= right) {
            temp[index++] = nums[j++];
        }
        index = 0;
        int k = left;
        while (k <= right) {
            nums[k++] = temp[index++];
        }
    }
}