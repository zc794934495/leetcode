class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int res = 0;
        //计算不使用技巧，满意的顾客数
        for(int i = 0;i < len;i++) {
            if(grumpy[i] == 0) {
                res += customers[i];
            }
        }
        int increase = 0;
        //计算0-X使用技巧增加的满意的顾客数
        for(int i = 0;i < X;i++) {
            increase += customers[i] * grumpy[i];
        }
        int index = X;
        int maxIncrease = increase;
        //移动滑动窗口找最大增加数
        while(index < len) {
            increase = increase - customers[index - X] * grumpy[index - X] + customers[index] * grumpy[index];
            maxIncrease = Math.max(maxIncrease,increase);
            index++;
        }
        return res + maxIncrease;
    }
}