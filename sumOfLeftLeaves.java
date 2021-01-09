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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //root有左节点并且左节点是叶子节点
        return (root.left!=null && root.left.left==null && root.left.right==null ? root.left.val : 0) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}