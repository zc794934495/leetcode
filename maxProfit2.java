class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        //不超过n/2时，最多完成k笔交易
        k = Math.min(k, n / 2);
        //buy[i]代表进行i笔交易，并且手上有股票的最大利润
        int[] buy = new int[k + 1];
        //sell[i]代表进行i笔交易，但手上没有股票的最大利润
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        //设置初始值，足够小，并且减去prices以后不会越界
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        //i代表天数  j代表第j笔交易
        for (int i = 1; i < n; ++i) {
            //没有进行交易但手上有股票的最大利润为：1.昨天手上就有股票2.昨天手上没有股票，买入今天的股票
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                //进行第j笔交易时手上有股票的最大利润为:1.昨天手上就有股票2.昨天手上没有股票，今天买入股票
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                //进行第j笔交易时手上没有股票的最大利润为：1.昨天手上就没有股票2.昨天手上有股票，今天卖出
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);   
            }
        }
        //返回最大值
        return Arrays.stream(sell).max().getAsInt();
    }
}