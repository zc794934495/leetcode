class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //根据结束时间排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int index = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0;i < intervals.length;i++){
            //判断是否重叠
            if(index > intervals[i][0]) {
                //重叠res++
                res++;
            }else {
                //不重叠则更新index
                index = intervals[i][1];
            }
        }
        return res;
    }
}