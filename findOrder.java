class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        //adj[i]表示以i课程为先修课程的课程集合
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        //inDegree[i]表示i课程的先修课程数
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            //p1是p0的先修课程
            adj[p[1]].add(p[0]);
            //p0的先修课程数加一
            inDegree[p[0]]++;
        }

        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //入度为0加入队列，即只有先修课程数为0才能入队
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // 当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer head = queue.poll();
            res[count] = head;
            count++;
            //学习完head，adj[head]中的课程的先修课程数减一
            Set<Integer> successors = adj[head];
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                // 马上检测该课程的先修课程数是否为 0，如果为 0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }
}