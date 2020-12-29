class Solution {
    public int minPatches(int[] nums, int n) {
        int len = nums.length;
        int res = 0;
        //因为n可能取到int最大值，则x最后会溢出
        long x = 1;
        int index = 0;
        while(x <= n) {
            //不断维护[1,x - 1]内都能被得到
            if(index < len && nums[index] <= x) {
                //x也可以被得到，更新x
                x += nums[index];
                index++;
            }else {
                //x不能被得到，需要补充x，然后更新x
                x += x;
                res++;
            }
        }
        return res;
    }
}
