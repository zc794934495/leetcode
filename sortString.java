class Solution {
    public String sortString(String s) {
        int[] nums = new int[26];
        //桶计数
        for(int i = 0;i < s.length();i++) {
            nums[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
            //顺序存
            for(int i = 0;i < 26;i++) {
                if(nums[i] > 0) {
                    sb.append((char)(i + 'a'));
                    nums[i]--;
                }
            }
            //逆序存
            for(int i = 25;i >= 0;i--) {
                if(nums[i] > 0) {
                    sb.append((char)(i + 'a'));
                    nums[i]--;
                }
            }
        }
        return sb.toString();
    }
}