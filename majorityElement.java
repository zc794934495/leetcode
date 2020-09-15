class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer x = null;
        for(int num : nums){
            if(count == 0){
                x = num;
            }
            count += (x == num)?1:-1;//是当前众数+1，不是-1；
        }
        return x;
    }
}