class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        //填dp表
        for(int right = 1;right <= len;right++) {
            for(int left = right - 1;left >= 0;left--) {
                if(wordSet.contains(s.substring(left,right)) && dp[left]) {
                    dp[right] = true;
                    break;
                }
            }
        }

        List<String> res = new ArrayList<>();
        //如果有解就回溯求解集
        if(dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(s,len,wordSet,dp,path,res);
            return res;
        }
        return res;
    }

    public void dfs(String s,int len,Set<String> wordSet,boolean[] dp,Deque<String> path,List<String> res) {
        if(len == 0) {
            //String.join(" ",path)在每一个path中间加一个空格
            res.add(String.join(" ",path));
            return;
        }
        for(int i = len - 1;i >= 0;i--) {
            String suffix = s.substring(i,len);
            if(wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s,i,wordSet,dp,path,res);
                path.removeFirst();
            }
        }
    }
}