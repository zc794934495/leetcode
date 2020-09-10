class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < len - 1;i++){
            int oddLen = expandAroundCenter(charArray,i,i);
            int evenLen = expandAroundCenter(charArray,i,i + 1);
            int curMaxLen = Math.max(oddLen,evenLen);
            if(curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    public int expandAroundCenter(char[] charArray,int left, int right){
        int i = left;
        int j = right;
        int len = charArray.length;
        while(i >= 0 && j < len){
            if(charArray[i] == charArray[j]){
                j++;
                i--;
            }else{
                break;
            }
        }
        //(j - 1) - (i + 1) + 1 = j - i -1
        return j - i - 1;
    }
}