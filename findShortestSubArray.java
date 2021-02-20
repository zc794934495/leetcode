class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        //键为数值，值分别存储频数，首次出现位置，最后出现位置
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0;i < len;i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else {
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int max = 0;
        int minLen = 0;
        for(Map.Entry<Integer,int[]> e : map.entrySet()) {
            if(max < e.getValue()[0]) {
                max = e.getValue()[0];
                minLen = e.getValue()[2] - e.getValue()[1] + 1;
            }else if(max == e.getValue()[0]) {
                minLen = Math.min(minLen,e.getValue()[2] - e.getValue()[1] + 1);
            }
        }
        return minLen;
    }
}