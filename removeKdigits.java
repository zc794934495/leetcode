class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        //当前数字小于栈顶元素，删除数字小于k个，栈不为空则：
        //栈顶元素出栈，直到跳出循环当前元素入栈
        for(int i = 0;i < num.length();i++) {
            char c = num.charAt(i);
            while(!deque.isEmpty() && k > 0 && deque.peekLast() > c){
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);     
        }
        //处理当前未删够k个数字，从末尾开始删除
        while(k != 0) {
            deque.pollLast();
            k--;
        }
        StringBuilder res = new StringBuilder();
        //用来删除前导0的标记
        boolean flag = true;
        while(!deque.isEmpty()) {
            char c = deque.pollFirst();
            //判断当前是否为0，如果为0是不是前导0
            if(flag && c == '0') {
                continue;
            }
            //说明没有前导0了，flag置为false
            flag = false;
            res.append(c);
        }
        //如果移出了所有数字返回"0",否则返回res
        return res.length() == 0 ? "0" : res.toString();
    }
}