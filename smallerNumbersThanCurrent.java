class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for(int i = 0;i < n;i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        //按照data[i][0]从小到大排序
        Arrays.sort(data,new Comparator<int[]>() {
            public int compare(int[] data1,int[] data2) {
                return data1[0] - data2[0];
            }
        });
        int[] ret = new int[n];
        int pre = -1;
        for(int i = 0;i < n;i++) {
            //i是严格小于这个数的数量
            if(pre == -1 || data[i][0] != data[i - 1][0]) {
                pre = i;
            }
            ret[data[i][1]] = pre;
        }
        return ret;
    }
}