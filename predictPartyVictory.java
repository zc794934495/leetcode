class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        //将字符放入队列
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            //比较两个队列首元素大小
            if (dire.peek() > radiant.peek()) {
                dire.poll();
                radiant.add(radiant.poll() + n);
            } else {
                radiant.poll();
                dire.add(dire.poll() + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}