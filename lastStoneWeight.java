class Solution {
    public int lastStoneWeight(int[] stones) {
        //大顶堆
        PriorityQueue<Integer> res = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer num1,Integer num2) {
                return num2 - num1;
            }
        });
        for(int num : stones) {
            res.add(num);
        }
        while(res.size() > 1) {
            int num1 = res.poll();
            int num2 = res.poll();
            if(num1 != num2) { //不相等返回新重量
                res.add(num1 - num2);
            }
        }
        //如果size不为1，则没有石头剩下返回0
        return res.size() == 1?res.poll() : 0;
    }
}