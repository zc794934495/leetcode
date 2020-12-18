/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //非递归
    // public List<Integer> rightSideView(TreeNode root) {
    //     Map<Integer,Integer> rightView = new HashMap<>();
    //     int maxDepth = -1;
    //     Stack<TreeNode> nodeStack = new Stack<>();
    //     Stack<Integer> depthStack = new Stack<>();
    //     nodeStack.push(root);
    //     depthStack.push(0);
    //     while(!nodeStack.isEmpty()) {
    //         //弹出一个节点和层数
    //         TreeNode node = nodeStack.pop();
    //         int depth = depthStack.pop();
    //         if(node != null) {
    //             maxDepth = Math.max(maxDepth,depth);
    //             //说明没有当前层没有放入节点的值
    //             if(!rightView.containsKey(depth)) {
    //                 rightView.put(depth,node.val);
    //             }
    //             nodeStack.push(node.left);
    //             nodeStack.push(node.right);
    //             depthStack.push(depth + 1);
    //             depthStack.push(depth + 1);
    //         }
    //     }
    //     //遍历每一层保存的最右节点值放入res
    //     List<Integer> res = new ArrayList<Integer>();
    //     for(int depth = 0;depth <= maxDepth;depth++) {
    //         res.add(rightView.get(depth));
    //     }
    //     return res;
    // } 
    //递归
    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int deep){
        if(root==null) {
            return;
        }
        if(deep==ans.size()) {//当deep和ans的长度一样的时，说明这一层还没有放入节点的值
            ans.add(root.val);
        }
        deep++;
        //有右节点优先遍历右节点
        dfs(root.right,deep);
        dfs(root.left,deep);
    }
}