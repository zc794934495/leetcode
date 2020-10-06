class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return len;
        }
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        for(int i = 1;i < len;i++){
            if(nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            }else{
                int left = 0;
                int right = end;
                while(left < right){
                    int mid = left + ((right - left) >>> 1);
                    if(tail[mid] < nums[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }
}