public class Solution {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }

        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            //将任意交换的结点对输入并查集
            unionFind.union(index1, index2);
        }

        //构建映射关系
        char[] charArray = s.toCharArray();
        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            //根据root作为key找到value：minHeap，如果没有就新建一个minHeap加入当前字符并建立映射
            hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        //重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        //从小到大依次找集合，保证字典序最小
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
    }

    private class UnionFind {

        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);//找到根
            int rootY = find(y);//找到根
            //根相同不需要合并
            if (rootX == rootY) {
                return;
            }

            //rootX为根节点的树和rootY为根结点的树“高度”相同
            if (rank[rootX] == rank[rootY]) {
                //把rootY为根结点的树并入rootX为根节点的树下
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度加 1
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                //把rootY为根结点的树并入rootX为根节点的树下
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                //把rootX为根节点的树并入rootY为根结点的树下
                // 同理，此时以 rootX 为根结点的树的高度不变
                parent[rootY] = rootX;
            }
        }
        //递归找到根节点，并且把当前节点的父节点变为根节点
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
