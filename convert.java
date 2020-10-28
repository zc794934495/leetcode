class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        //向list里放入numrows或s.length()个StringBuilder
        for(int i = 0;i < Math.min(numRows,s.length());i++) {
            list.add(new StringBuilder());
        }
        int curRows = 0;
        boolean flag = false;
        //遍历字符串，当curRows为0和numRows - 1时，将flag置为！flag，反向添加字符
        for(char c : s.toCharArray()) {
            list.get(curRows).append(c);
            if(curRows == 0 || curRows == numRows - 1) {
                flag = !flag;
            }
            curRows += flag? 1 : -1;
        }
        //拼接list中的字符串
        StringBuilder ret = new StringBuilder();
        for(StringBuilder str : list) {
            ret.append(str);
        }
        return ret.toString();
    }
}