class Solution {
    public int countPrimes(int n) {
        //默认大于1的所有数都是质数
        int[] nums = new int[n];
        int res = 0;
        for(int i = 2;i < n;i++) {
            //当前数是0（质数）
            if(nums[i] == 0) {
                res++;
                if((long)i * i < n) {
                    //将当前数字的倍数都置为1（非质数）
                    for(int j = i * i;j < n;j += i) {
                        nums[j] = 1;
                    }
                }
            }
        }
        return res;
    }
}