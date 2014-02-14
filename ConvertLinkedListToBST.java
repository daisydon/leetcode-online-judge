/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public static ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        int n = getLength(head);
        return helper(1, n);
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }
    
    private TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = helper(mid + 1, end);
        root.left = left;
        root.right = right;
        
        return root;
    }
    
}