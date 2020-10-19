class Solution {
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int Sskip = 0;
        int Tskip = 0;
        while(i >= 0 || j >= 0){ //当两个字符串不都遍历结束
            while(i >= 0) { //当S不为空，找到下一个不被回退的字符
                if(S.charAt(i) == '#'){
                    Sskip++;
                    i--;
                }else if(Sskip > 0) {
                    Sskip--;
                    i--;
                }else{
                    break;
                }
            }
            while(j >= 0) { //当T不为空，找到下一个不被回退的字符
                if(T.charAt(j) == '#'){
                    Tskip++;
                    j--;
                }else if(Tskip > 0) {
                    Tskip--;
                    j--;
                }else{
                    break;
                }
            }
            if(i >= 0 && j >= 0) {
                if(S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            }else if(i >= 0 || j >= 0){ //有一个遍历完，另一个还有非#的字符
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}