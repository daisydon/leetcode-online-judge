/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        if (root == null) return set;
        ArrayList<Integer> acc = new ArrayList<>();
        Stack<TreeNode> cur = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        cur.push(root);
        boolean LtoR = true;
        
        while(!cur.isEmpty()) {
            
            TreeNode parent = cur.pop();
            if (parent != null) {
                acc.add(parent.val);
               if (LtoR) {
                next.push(parent.left);
                next.push(parent.right);
                }
                else {
                next.push(parent.right);
                next.push(parent.left);
               }
             }
          
           if (cur.isEmpty()) {
                cur.addAll(next);
                LtoR = !LtoR;
                next = new Stack<TreeNode>();
                if (acc.size() > 0) set.add(new ArrayList<Integer>(acc));
                acc = new ArrayList<Integer>();
            }
        }
        return set;
    }
}