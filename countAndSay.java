class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int length = str.length();
        int start = 0; //记录重复字符的起始位置
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
            } else if (str.charAt(i) != str.charAt(start) ) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }
}
