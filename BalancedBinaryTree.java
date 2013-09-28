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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return height(root)!=-1;
        
    }
    private int height(TreeNode root){
        if(root==null)
         return 0;
        
        int leftheight=height(root.left);
        if(leftheight==-1)
         return -1;
        
        int rightheight=height(root.right);
        if(rightheight==-1)
         return -1;
        
        if(Math.abs(leftheight-rightheight)>1)
         return -1;
         
        return 1+Math.max(leftheight,rightheight);
        
        
    }
}
