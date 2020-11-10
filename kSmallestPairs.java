class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            //小顶堆的比较器是基于坐标比较
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });
        List<List<Integer>> res = new LinkedList<>();
        
        // 两个数组有一个为空，返回空
        if(nums1.length == 0 || nums2.length == 0){
            return res;
        }

        // 第一个数组的i号下标和第二个数组的0号下标加入小顶堆
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(new int[] { i, 0 }); // 加入的是坐标
        }

        // 循环K次或者堆空
        while (k > 0 && !queue.isEmpty()) {
            // 弹出堆顶元素（第一个数组下标的元素加第二个数组下标元素和最小的）
            int[] pair = queue.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[pair[0]]);
            item.add(nums2[pair[1]]);

            // 第一个数组下标不变，第二个数组的下标加1，加入小顶堆
            if (pair[1] < nums2.length - 1) {
                queue.add(new int[] { pair[0], pair[1] + 1 });
            }
            res.add(item);
            k--;
        }
        return res;
    }
}
