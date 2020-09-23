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
    public boolean isValidBST(TreeNode root) {  
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;//上一个值

        while(!deque.isEmpty() || root != null){
            while(root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if(root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}