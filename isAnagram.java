class Solution {
    //用哈希表
    // public boolean isAnagram(String s, String t) {
    //     if(s.length() != t.length()) {
    //         return false;
    //     }
    //     Map<Character,Integer> map = new HashMap<>();
    //     for(char c : s.toCharArray()) {
    //         map.put(c,map.getOrDefault(c,0) + 1);
    //     }
    //     for(char c : t.toCharArray()) {
    //         map.put(c,map.getOrDefault(c,0) - 1);
    //         if(map.get(c) < 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    //遍历到s的字符对应位置加一，遍历到t的字符对应位置减一，如果存在不为0的位置则返回false
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < ss.length; ++i) {
            cnt[ss[i] - 'a'] ++;
            cnt[tt[i] - 'a'] --;
        }
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}