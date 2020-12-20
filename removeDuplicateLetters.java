class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] used = new boolean[26];
        int[] nums = new int[26];
        for(char c : s.toCharArray()) {
            nums[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            //当前字母是否已经被拼接过
            if(!used[c - 'a']) {
                //当前字母比sb最后一位小
                while(sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                    //只有后面还会出现sb最后一个字母时，可以删除最后一个字母，并设置这个字母为未拼接过
                    if(nums[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        used[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else {
                        break;
                    }
                }
                //添加当前字母，并设置为拼接过
                sb.append(c);
                used[c - 'a'] = true;
            }
            //当前字母后续存在的次数减一
            nums[c - 'a']--;
        }
        return sb.toString();
    }
}