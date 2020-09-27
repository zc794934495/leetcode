class Solution {
    public String getPermutation(int n, int k) {
        final int[] arr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used,false);
        StringBuilder s = new StringBuilder();
        for(int i = n - 1;i >= 0;i--){
            int cnt = arr[i];
            for(int j = 1;j <= n;j++){
                if(used[j]){
                    continue;
                }
                if(k > cnt){
                    k -= cnt;
                    continue;
                }
                used[j] = true;
                s.append(j);
                break;
            }
        }
        return s.toString();
    }
}