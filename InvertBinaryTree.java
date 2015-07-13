/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
         if (root != null) {
             revertHelper(root);
         }
         return root;
    }
    
    public void revertHelper(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        if (node.right != null) {
            revertHelper(node.right);
        }
        if (node.left != null) {
            revertHelper(node.left);
        }
    }
}