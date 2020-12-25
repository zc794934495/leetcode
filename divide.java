class Solution {
    public int divide(int dividend, int divisor) {
        //记录是否异号
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        //方便处理边界问题，都置为负数
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            //dividend每次减去2^n个divisor
            while (dividend <= (temp_divisor << 1)) {
                //不能再<<1（防止溢出）
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        //同号要取相反数
        if (!sign) {
            //最小值需要转换为最大值
            if (result == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }
}