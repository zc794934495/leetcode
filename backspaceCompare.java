class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s = simplification(S);
        String t = simplification(T);
        //简化后都为null
        if(s == null && t == null){
            return true;
        }
        //简化后长度不一致
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        //比较简化后的字符串
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    //简化字符串，按规则去除#
    public String simplification(String S) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0;i < S.length();i++) {
            char c = S.charAt(i);
            if(c == '#') {
                if(deque.size() != 0){
                    deque.pop();
                }
            }else {
                deque.push(c);
            }
        }
        String str = "";
        while(!deque.isEmpty()){
            str += deque.removeLast();
        }
        return str;
    }
}