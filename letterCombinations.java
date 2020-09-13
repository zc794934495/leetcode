class Solution {
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
            };
            public ArrayList<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();

        if(digits.equals("")){
            return res;
        }
        findCombination(digits,0,"");
        return res;
    }

    public void findCombination(String digits,int index,String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0;i < letters.length();i++){
            findCombination(digits,index + 1,s + letters.charAt(i));
        }
    }
}