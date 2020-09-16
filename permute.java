class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean[] a = new boolean[len];
        if(len == 0){
            return res;
        }

        dfs(nums,len,0,path,a,res);
        return res;
    }

    public void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] a,List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList(path));
            return;
        }

        for(int i = 0;i < len;i++){
            if(!a[i]){
                path.add(nums[i]);
                a[i] = true;
                dfs(nums,len,depth + 1,path,a,res);
                a[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }
}