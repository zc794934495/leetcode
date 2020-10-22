class Solution {
    //字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段
    //同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
    public List<Integer> partitionLabels(String S) {
        int[] nums = new int[26];
        int len = S.length();
        for(int i = 0;i < len;i++) {
            nums[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0;i < len;i++) {
            end = Math.max(end,nums[S.charAt(i) - 'a']);
            if(end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}