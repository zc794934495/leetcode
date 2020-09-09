class Solution {
    public int lengthOfLongestSubstring(String s) {
        int MaxSize = 0;
        int key = 0;
        int base = 0;
        int i = 0;
        int[] dict = new int[256];
        while(key < s.length()){
            i = s.charAt(key);
            if(dict[i] > base){
                base = dict[i];
            }
            dict[i] = key + 1;
            MaxSize = (MaxSize > key - base + 1)? MaxSize:key - base + 1;
            key++;
        }
        return MaxSize;
    }
}