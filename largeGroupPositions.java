class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0,end = 1;
        int count = 1;
        while(end < s.length()) {
            if(s.charAt(end) == s.charAt(start)) {
                count++;
            }else {
                if(count >= 3) {
                    res.add(Arrays.asList(start, end - 1));
                }
                start = end;
                count = 1;
            }
            end++;
        }
        //整个字符串都是相同字符
        if(count >= 3) {
            res.add(Arrays.asList(start, end - 1));
        }
        return res;
    }
}