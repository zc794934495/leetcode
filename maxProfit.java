class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0; //手上没有股票
        int buy = -prices[0];  //手上有股票
        for(int i = 1;i < prices.length;i++) {
            //昨天手上就没股票，昨天手上有股票今天卖出
            sell = Math.max(sell,buy - fee + prices[i]);
            //昨天手上就有股票，昨天手上没股票，今天买入
            buy = Math.max(buy,sell - prices[i]);
        }
        return sell;
    }
}