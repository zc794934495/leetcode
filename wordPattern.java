class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String,Character> sMap = new HashMap<>();
        Map<Character,String> pMap = new HashMap<>();
        int len = s.length();
        int start = 0;
        for(int k = 0;k < pattern.length();k++) {
            char c = pattern.charAt(k);
            //判断start是否越界
            if(start >= len) {
                return false;
            }
            int end = start;
            while(end < len && s.charAt(end) != ' ') {
                end++;
            }
            //提取一个单词
            String temp = s.substring(start,end);
            if(sMap.containsKey(temp) && sMap.get(temp) != c) {
                return false;
            }
            if(pMap.containsKey(c) && !temp.equals(pMap.get(c))) {
                return false;
            }
            sMap.put(temp,c);
            pMap.put(c,temp);
            start = end + 1;
        }
        return start >= len;
    }
}