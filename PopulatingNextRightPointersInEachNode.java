/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null)  return;
        if (root.left == null && root.right == null)  return;
        TreeLinkNode rsbling= root.next;
        
        if(rsbling!=null){ 
            root.left.next = root.right;
            root.right.next = rsbling.left;
            }
        else{
            root.left.next = root.right;
            root.right.next = null;
         }
            connect(root.left);
            connect(root.right);
     }
   }