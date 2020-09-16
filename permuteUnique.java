    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Dclass Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[len];
        if(len == 0){
            return res;
        }
        Arrays.sort(nums);//
        dfs(nums,len,0,path,used,res);
        return res;
    }

    public void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0;i < len;i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){  //
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,len,depth + 1,path,used,res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}