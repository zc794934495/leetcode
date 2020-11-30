class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        if(n < 2) {
            return S;
        }
        //统计字母出现次数
        int[] map = new int[26];
        for(char c : S.toCharArray()) {
            map[c - 'a']++;
            //该字母出现次数超过(n + 1) / 2，一定会有相邻字符相同
            if(map[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }
        char[] res = new char[n];
        int evenIndex = 0;
        int oddIndex = 1;
        //因为偶数下标个数等于奇数下标个数（n为偶数）或比奇数下标个数多一个（n为奇数）
        //所以当字母出现次数等于(n + 1) / 2时，全部放在偶数位置上，刚好可以满足两相邻字符不同
        for(int i = 0;i < 26;i++){
            //该字母出现次数小于等于一半，先放在奇数位置上
            while(map[i] > 0 && map[i] <= n / 2 && oddIndex < n) {
                res[oddIndex] = (char)(i + 'a');
                map[i]--;
                oddIndex += 2;
            }
            //上面的循环因为oddIndex >= n跳出 ：
            //          说明没有字母出现次数等于(n + 1) / 2，则将剩余出现字符依次放在偶数位置上
            //上面的循环因为map[i] > n/2跳出：
            //          则将该字母全部放在偶数位置上，刚好放完
            while(map[i] > 0) {
                res[evenIndex] = (char)(i + 'a');
                map[i]--;
                evenIndex += 2;
            }
        }
        return new String(res);
    }
}