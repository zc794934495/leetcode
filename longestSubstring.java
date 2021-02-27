class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        //保存[l,r]中所有字符出现次数
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        //找到第一个出现次数大于0小于k的
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        //该子串所有字符出现次数都不少于k，返回长度
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int res = 0;
        while (i <= r) {
            //找到不等于split的下标，确定子串左边界
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            //找到等于split的下标，确定子串右边界
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            //找子串中符合条件的长度
            int length = dfs(s, start, i - 1, k);
            //取最大长度
            res = Math.max(res, length);
        }
        return res;
    }
}
