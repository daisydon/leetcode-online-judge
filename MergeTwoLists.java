/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode head = null, prev = null;
        
        while(l1!= null || l2!= null){
            ListNode advanced = null;
            if(l1 == null){
                advanced = l2;}
            else if(l2 == null){
                advanced = l1;
            }
            else if (l1.val > l2.val){
                advanced = l2;
            }
            else if (l2.val >= l1.val){
                advanced = l1;
            }
            
            if(prev == null){
                head = advanced;
            }
            else{
                prev.next = advanced;
            }
            prev = advanced;
            if(l1 == advanced){
                l1 = l1.next; }
            else{
                l2 = l2.next;
            }
            
        }
        return head;
    }
}