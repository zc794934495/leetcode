class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int temp = 0;
        int len = nums.length;
        while(temp < len) {
            int end = temp + 1;
            int start = temp;
            while(end < len && nums[temp] + 1 == nums[end]) {
                end++;
                temp++;
            }
            //判断[start,temp]是否只有一个数
            if(temp != start) {
                res.add(nums[start] + "->" + nums[temp]);
            }else {
                res.add(nums[start] + "");
            } 
            temp++;
        }
        return res;   
    }
}