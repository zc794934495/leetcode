class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();
        
        int[] map = new int[26];
        int[] winMap = new int[26];
        //存放s1的字符及出现次数
        for(int i = 0;i < m;i++) {
            map[pattern[i] - 'a']++;
        }
        int count = 0;
        //统计s1的字符个数
        for(int i = 0;i < 26;i++) {
            if(map[i] > 0) {
                count++;
            }
        }
                
        int left = 0;
        int right = 0;
        int winCount = 0;
        while(right < n) {
            //滑动窗口右边界的字符在s1中出现过
            if(map[text[right] - 'a'] > 0) {
                winMap[text[right] - 'a']++;
                //并且出现次数相同winCount++
                if(winMap[text[right] - 'a'] == map[text[right] - 'a']) {
                    winCount++;
                }
            }
            right++;
            //当滑动窗口中字符出现个数和s1中出现个数相同
            while(count == winCount) {
                //长度相同返回true
                if(right - left == m) {
                    return true;
                }
                //滑动窗口左边界在s1中
                if(map[text[left] - 'a'] > 0) {
                    winMap[text[left] - 'a']--;
                    //滑动窗口中左边界出现次数小于s1中出现次数winCount--
                    if(winMap[text[left] - 'a'] < map[text[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }
}
