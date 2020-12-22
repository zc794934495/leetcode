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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //用于判断当前行应该头插还是尾插
        boolean flag = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Deque<Integer> path = new LinkedList<>();
            while (path.size() != len) {
                TreeNode node = queue.poll();
                if (!flag) { //当前行需要尾插（从左往右）
                    path.offerLast(node.val);
                } else {  //当前行需要头插（从右往左）
                    path.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new LinkedList<Integer>(path));
            flag = !flag;
        }
        return res;
    }
}