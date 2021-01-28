class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int lSum = 0;
        int rSum = 0;
        for(int i = 0;i <nums.length;i++){
           if(i == 0){
               lSum = 0;
           }else{
               lSum += nums[i-1];
           }
           rSum = sum - nums[i] - lSum;
           if(rSum == lSum){
               return i;
           }
        }
        return -1;
    }
}