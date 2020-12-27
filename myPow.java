class Solution {
    public double myPow(double x, int n) {
        //处理int溢出
        long N = n;
        return N > 0 ? quickMul(x,N) : 1.0 / quickMul(x,-N);
    }

    private double quickMul(double x,long N) {
        double res = 1.0;
        double contribute = x;
        while(N > 0) {
            if(N % 2 == 1) {
                //N 二进制表示的最低位为 1，需要计入贡献
                res *= contribute;
            }
            //平方
            contribute *= contribute;
            // 舍弃 N 二进制表示的最低位
            N = N / 2;
        }
        return res;
    }
}