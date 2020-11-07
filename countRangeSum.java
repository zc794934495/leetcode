class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        //求出前缀和
        for(int i = 0;i < nums.length;i++) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum,lower,upper,0,sum.length - 1);
    }
    //对前缀和数组sum归并排序并统计个数
    public int countRangeSumRecursive(long[] sum,int lower,int upper,int left,int right) {
        if(left == right) {
            return 0;
        }else {
            //分为两个数组
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum,lower,upper,left,mid);
            int n2 = countRangeSumRecursive(sum,lower,upper,mid + 1,right);
            int ret = n1 + n2;
            //统计个数
            int i = left;//左边数组的左初始边界
            int l = mid + 1;//右边数组的左初始边界
            int r = mid + 1;
            while(i <= mid) {
                while(l <= right && sum[l] - sum[i] < lower) {//求差值小于lower的数量
                    l++;
                }
                while(r <= right && sum[r] - sum[i] <= upper) {//求差值小于等于upper的数量
                    r++;
                }
                ret += r - l;  //差值在lower ~ upper的数量
                i++;
            }
            //合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left,p2 = mid + 1;
            int p = 0;
            while(p1 <= mid && p2 <= right) {
                if(sum[p1] <= sum[p2]) {
                    sorted[p] = (int)sum[p1];
                    p++;
                    p1++;
                } else {
                    sorted[p] = (int)sum[p2];
                    p++;
                    p2++;
                }
            }
            while(p1 <= mid) {
                sorted[p] = (int)sum[p1];
                p++;
                p1++;
            }
            while(p2 <= right) {
                sorted[p] = (int)sum[p2];
                p++;
                p2++;                
            }
            //放回sum中
            p = 0;
            int sortedLeft = left;
            while(sortedLeft <= right) {
                sum[sortedLeft] = sorted[p];
                p++;
                sortedLeft++;
            }
            return ret;
        }
    }
}