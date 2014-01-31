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
    public ListNode partition(ListNode head, int x) {
        ListNode firststart = null;
        ListNode firstend = null;
        ListNode secondstart = null;
        ListNode secondend = null;
        ListNode scanner = head;
        
        while(scanner != null) {
            if (scanner.val < x) {
              if (firststart == null) {
                  firststart = scanner;
                  firstend = scanner;
                  scanner = scanner.next;
              } else {
                  firstend.next = scanner;
                  firstend = firstend.next;
                  scanner = scanner.next;
              }
               firstend.next = null;  
            }
            else {
                if (secondstart == null) {
                    secondstart = scanner;
                    secondend = scanner;
                    scanner = scanner.next;
                } 
                else { 
                    secondend.next = scanner;
                    secondend = secondend.next;
                    scanner = scanner.next;
                }
                secondend.next = null;
            }
            
        }
        
        if (secondstart == null) {
            return firststart;
        }
        
        else if (firststart == null) {
            return secondstart;
        }
        else {
            return Merge(firststart,firstend, secondstart, secondend);
        }
        
    }
    
    private ListNode Merge(ListNode firststart, ListNode firstend, ListNode secondstart, ListNode secondend) {
        firstend.next = secondstart;
        return firststart;
    }
}