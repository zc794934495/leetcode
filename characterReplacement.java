class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if(len < 2) {
            return len;
        }
        char[] ch = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] map = new int[26];
        while(right < len) {
            //当前字符个数加一
            map[ch[right] - 'A']++;
            //当前窗口内出现次数最多的字母的出现次数
            maxCount = Math.max(maxCount,map[ch[right] - 'A']);
            right++;
            if(right - left > maxCount + k) {
                //说明k不够用，左边界移动并且对应字母出现次数减少
                map[ch[left] - 'A']--;
                left++;
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}