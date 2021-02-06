class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int size = n - k;
        int sum = 0;
        //长度为n-k的滑动窗口
        for(int i = 0;i < size;i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        //找到和最小的滑动窗口
        for(int i = size;i < n;i++) {
            sum += cardPoints[i] - cardPoints[i - size];
            minSum = Math.min(minSum,sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}