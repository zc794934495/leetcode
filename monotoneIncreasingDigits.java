class Solution {
    public int monotoneIncreasingDigits(int N) {
        int rs = 0, exp = 1, p = 10;//exp是当前位的权值，p是右边数字的大小，初始默认为10
        while (N > 0) {
            //取得当前位
            int t = N % 10;
            //当前位与上一位比较
            if (t <= p) {
                rs += t * exp;
                p = t;
            } else {
                //当前位乘以当前权值-1即为最大单增值
                rs = t * exp - 1;
                //当前位-1
                p = t - 1;
            }
            N /= 10;
            exp *= 10;
        }
        return rs;
    }
}