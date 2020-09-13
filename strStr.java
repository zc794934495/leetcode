class Solution {
    public int strStr(String haystack, String needle) {
        int j = needle.length();
        int i = 0;
        if(needle.isEmpty()){
            return 0;
        }else if(haystack.length() < needle.length()){
            return -1;
        }
        for(i = 0;i <= haystack.length() - needle.length();i++){
            char c = haystack.charAt(i);
            if(c == needle.charAt(0)){
                if(haystack.substring(i,j).equals(needle)){
                    return i;
                }
                j++;                
            }else{
                j++;
            }
        }
        return -1;
    }
}