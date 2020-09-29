class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if(len == 0){
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s,len,0,path,res);
        return res;
    }
    public void dfs(String s,int len,int start,Deque<String> path,List<List<String>> res){
        if(start == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start;i < len;i++){
            if(!checkPalindrome(s,start,i)){
                continue;
            }
            path.addLast(s.substring(start,i + 1));
            dfs(s,len,i + 1,path,res);
            path.removeLast();
        }
    }
    public boolean checkPalindrome(String str,int left,int right){
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}