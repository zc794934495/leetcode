class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for(int[] stone : stones) {
            //纵坐标+10001与横坐标区分
            uf.union(stone[0] + 10001,stone[1]);
        }
        //石子个数 - 连通分量
        return stones.length -  uf.getCount();
    }

    private class UnionFind {

        private Map<Integer, Integer> parent;
        private int count; //连通分量

        public UnionFind() {
            parent = new HashMap<>();
            count = 0;
        }
        
        public int getCount() {
            return count;
        }

        public void union(int x,int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }
            parent.put(rootX,rootY);
            count--;
        }

        public int find(int x) {
            //增加连通分量
            if(!parent.containsKey(x)) {
                parent.put(x,x);
                count++;
            }
            if(x != parent.get(x)) {
                parent.put(x,find(parent.get(x)));
            }
            return parent.get(x);
        }
    }
}