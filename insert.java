class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = true;
        List<int[]> list = new ArrayList<>();
        for(int[] nums : intervals) { 
            if(nums[0] > right) { //newInterval不与nums重叠，并且在nums的左侧
                if(placed) { //如果newInterval没被add则add
                    list.add(new int[]{left,right});
                    placed = false;
                }
                list.add(nums);
            }else if(nums[1] < left) {  //newInterval不与nums重叠，并且在nums右边
                list.add(nums);
            }else { //newInterval与nums重叠，合并区间成为新的newInterval
                left = Math.min(left,nums[0]);
                right = Math.max(right,nums[1]);
            }
        }
        if(placed) {   //说明遍历完intervals所有的nums都比newInterval的左边界小
            list.add(new int[]{left,right});
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0;i <list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}