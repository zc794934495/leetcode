class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] nums = new int[100];
        for(int[] domino : dominoes) {
            //较小的数*10+较大的数存入nums中
            int index = domino[0] > domino[1] ? domino[1] * 10 + domino[0] : domino[0] * 10 + domino[1];
            res += nums[index];
            nums[index]++;
        }
        return res;
    }
}