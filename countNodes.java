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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        //左子树层数和右子树层数相等说明左子树为满二叉树，计算右子树
        if(leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        }else { //说明右子树为满二叉树，计算左子树
            return countNodes(root.left) + (1 << rightLevel);
        } 
    }
    //计算数的高度
    private int countLevel(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 0;
        TreeNode cur = root;
        while(cur != null) {
            level++;
            cur = cur.left;
        }
        return level;
    }
}