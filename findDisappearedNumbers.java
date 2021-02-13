class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        //遍历每个数，使这个数前一个数加n
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //当数字小于n，后一个数不在原数组中
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}