class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emailToIndex = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        int count = 0;
        //遍历accounts获取账户名和邮箱地址
        for(List<String> account : accounts) {
            //得到名字
            String name = account.get(0);
            int size = account.size();
            for(int i = 1;i < size;i++) {
                //将email分别与int编号、name映射
                String email = account.get(i);
                if(!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email,count++);
                    emailToName.put(email,name);
                }
            }
        }
        UnionFind uf = new UnionFind(count);
        for(List<String> account : accounts) {
            //得到第一个email
            String firstEmail = account.get(1);
            //并通过emailToIndex得到email映射的编号
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for(int i = 2;i < size;i++) {
                //获取下一封email
                String nextEmail = account.get(i);
                //获取email映射编号
                int nextIndex = emailToIndex.get(nextEmail);
                //将email与email合并
                uf.union(firstIndex,nextIndex);
            }
        }

        Map<Integer,List<String>> indexToEmails = new HashMap<>();
        //遍历emailToIndex的键获取所有email
        for(String email : emailToIndex.keySet()) {
            //获取到email的编号寻找根节点（第一封email）
            int index = uf.find(emailToIndex.get(email));
            //根据根节点获取相关的email集合
            List<String> account = indexToEmails.getOrDefault(index,new ArrayList<String>());
            //将当前email加入根节点（第一封email）的email集合
            account.add(email);
            //建立根节点（第一封email）编号与email集合映射
            indexToEmails.put(index,account);
        }

        List<List<String>> res = new ArrayList<>();
        //遍历indexToEmails所有的值获得所有的email集合
        for(List<String> emails : indexToEmails.values()) {
            //对集合进行字典序排序
            Collections.sort(emails);
            //通过集合中第一封email获取所属name
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            //加入name，所属的email集合
            account.add(name);
            account.addAll(emails);
            //加入结果集
            res.add(account);
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;
        
        public UnionFind(int count) {
            parent = new int[count];
            for(int i = 0;i < count;i++) {
                parent[i] = i;
            }
        }

        public void union(int x,int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}