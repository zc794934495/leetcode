class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] charArray = S.toCharArray();
        dfs(charArray,0,res);
        return res;
    }
    public void dfs(char[] charArray,int index,List<String> res){
        if(index == charArray.length){
            res.add(new String(charArray));
            return;
        }
        dfs(charArray,index + 1,res);
        if(Character.isLetter(charArray[index])){
            charArray[index] ^= 1 << 5;//异或1 << 5(32)变化大小写
            dfs(charArray,index + 1,res);
            charArray[index] ^= 1 << 5;
        }
    }
}