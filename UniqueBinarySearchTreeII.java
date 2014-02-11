/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generater(1, n);
    }
    
    private ArrayList<TreeNode> generater(int a, int b) {
        ArrayList<TreeNode> acc = new ArrayList<>();
        if (a < b) {
            
            for (int i = a; i <= b; i++) {
                ArrayList<TreeNode> leftsub = generater(a, i - 1);
                ArrayList<TreeNode> rightsub = generater(i + 1, b);
                
                for (TreeNode l : leftsub) {
                    for (TreeNode r: rightsub) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        acc.add(root);
                    }
                }
                
            }
        }
        else if (a == b) {
            acc.add(new TreeNode(a));
        }
        else {
            acc.add(null);
        }
        return acc;
    }
}