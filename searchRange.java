class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return new int[]{-1,-1};
        }
        int first = findFirstPosition(nums,target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = findLastPosition(nums,target);
        
        return new int[]{first,last};

    }

    public int findFirstPosition(int[] nums,int target){
        int L = 0;
        int R = nums.length - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(target == nums[mid]){
                R = mid - 1;
            }else if(target < nums[mid]){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        if (L != nums.length && nums[L] == target) {
            return L;
        }
            return -1;
    }
    public int findLastPosition(int[] nums,int target){
        int L = 0;
        int R = nums.length - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(target == nums[mid]){
                L = mid + 1;
            }else if(target < nums[mid]){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
            return R;
    }
}