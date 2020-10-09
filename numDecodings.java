class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        char[] c = s.toCharArray();
        if(c[0] == '0'){
            return 0;
        }
        dp[0] = 1;
        for(int i = 1;i < len;i++){
            if(c[i] != '0'){
                dp[i] = dp[i - 1];
            }
            int num = 10 * (c[i - 1] - '0') + (c[i] - '0');
            if(num >= 10 && num <= 26){
                if(i == 1){
                    dp[i]++;
                }else{
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}