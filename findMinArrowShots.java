class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        //按结束端点升序排序，如果按照起始端点升序排序会出现
        //(0,12),(2,5),(9,15)这种情况，较难处理
        Arrays.sort(points,new Comparator<int[]>() {
            public int compare(int[] o1,int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        //如果数组不为空则默认第一个数组射出了箭，并从第一个数组结尾开始移动箭
        //可以避免第一个数字为int类型的下界的情况
        int count = 1;
        int tp = points[0][1];
        for(int[] nums : points) {
            if(tp < nums[0]) {
                tp = nums[1];
                count++;
            }
        }
        return count;
    }
}