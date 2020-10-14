class Solution {
    public List<String> commonChars(String[] A) {
        int[] minNums = new int[26];
        //赋为最大值，为了比小不受影响
        Arrays.fill(minNums,Integer.MAX_VALUE);
        for(String word : A){
            int[] nums = new int[26];
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                ++nums[c - 'a'];
            }
            //向minNums中放入字符的最小出现次数
            for(int i = 0;i < 26;i++){
                minNums[i] = Math.min(minNums[i],nums[i]);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0;i < 26;i++){
            for(int j = 0;j < minNums[i];j++)
            res.add(String.valueOf((char)(i + 'a')));
        }
        return res;
    }
}