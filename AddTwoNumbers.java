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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null && l2 != null) return l2;
        else if (l1 != null && l2 == null) return l1;
         
        ListNode head = null;
        ListNode tail = null;
        int acc = 0; //for next
        
        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + acc;
            if (cur >= 10) {
               cur = cur - 10;
               acc = 1;
            }
            else {
                acc = 0;
            }
            ListNode digit = new ListNode(cur);
            if (head == null) {
                head = digit;
                
            }
            else if (tail == null) {
                tail = digit;
                head.next = tail;
            }
            else {
                tail.next = digit;
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int cur = l1.val + acc;
            if (cur >= 10) {
                cur = cur - 10;
                acc = 1;
            }
            else {
                acc = 0;
            }
            ListNode digit = new ListNode(cur);
            if (tail == null) {
                tail = digit;
                head.next = tail;
            }
            else {
                tail.next = digit;
                tail = tail.next;
            }
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int cur = l2.val + acc;
            if (cur >= 10) {
                cur = cur - 10;
                acc = 1;
            }
            else {
                acc = 0;
            }
            ListNode digit = new ListNode(cur);
            if (tail == null) {
                tail = digit;
                head.next = tail;
            }
            else {
                tail.next = digit;
                tail = tail.next;
            }
            l2 = l2.next;
         }
        
        if(acc == 1) {
            ListNode digit = new ListNode(acc);
            if (tail == null) {
                tail = digit;
                head.next = tail;
            }
            else {
                tail.next = digit;
                tail = tail.next;
            }
        }
        return head;
    }
}