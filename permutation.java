class Solution {
    public String[] permutation(String s) {
        int len = s.length();
        if(len == 0){
            return new String[0];
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[len];
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(arr,0,len,used,str,res);
        return res.toArray(new String[0]);
    }

    public void dfs(char[] arr,int depth,int len,boolean[] used,StringBuilder str,List<String> res){
        if(depth == len){
            res.add(str.toString());
            return;
        }
        for(int i = 0;i < len;i++){
            if(!used[i]){
                if(i > 0 && arr[i] == arr[i - 1] && !used[i - 1]){
                    continue;
                }
                str.append(arr[i]);
                used[i] = true;
                dfs(arr,depth + 1,len,used,str,res);
                str.deleteCharAt(str.length() - 1);
                used[i] = false;
            }
            
        }
    }
}