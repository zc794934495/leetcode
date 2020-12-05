class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A'] += 1;
        }
        //最大执行次数
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        //(最多的那个任务的任务数 - 1) * (间隔 + 1) + 任务数量等于最大的任务数的数量
        int maxCount = (n + 1) * (max - 1);
        for (int count : counts) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max(maxCount, tasks.length);
    }
}