/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxSize = 0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,1,1,new ArrayList<>());
        return maxSize;
    }
    //left只保存每层的左端点的下标
    public void dfs(TreeNode r, int level, int index, List<Integer> left) {
        if(r == null) {
            return;
        }
        //left只保存最左端节点的下标，一层只保存一个节点，即有多少层就保存多少下标
        //层数大于size说明当前节点是下一层的最左端点
        if(level > left.size()) {
            left.add(index);
        }
        //当前节点的index-当前层最左端的index + 1就是当前节点到最左端的长度
        // 即该层到当前节点为止的宽度
        maxSize = Math.max(maxSize,index - left.get(level - 1) + 1);
        dfs(r.left,level + 1,index * 2,left);//节点（下标为index）的左孩子节点下标为index * 2
        dfs(r.right,level + 1,index * 2 + 1,left);//节点（下标为index）的右孩子节点下标为index * 2 + 1
    }
}