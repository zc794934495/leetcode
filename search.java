class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return target == nums[0]?0:-1;
        }

        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return  -1;
    }
}