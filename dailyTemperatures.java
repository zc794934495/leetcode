class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        //单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i < len;i++) {
            //栈顶元素小于当前元素，存入下标之差
            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            //当前元素入栈
            stack.push(i);
        }
        return res;
    }
}