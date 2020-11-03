class StockSpanner {
    Stack<Integer> prices,wegihts;
    public StockSpanner() {
        prices = new Stack();
        wegihts = new Stack(); //用来存储当前递减栈长度
    }
    
    public int next(int price) {
        int w = 1;
        //prices栈不为空，且prices的栈顶小于当前price，就将w + 当前递减栈长度
        while(!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += wegihts.pop();
        }
        wegihts.push(w);
        prices.push(price);
        return w;
    }
}