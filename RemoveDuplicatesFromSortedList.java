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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)  return null;
        else{
         ListNode n1=new ListNode(head.val);
         n1.next=head.next;
         while(n1.next!=null){
              ListNode n2 = new ListNode(n1.next.val);
              n2.next = n1.next.next;
              if(n1.val!=n2.val) {
                n1 = n1.next;
                n2 = n2.next;
             }
              else{
                n1.next = n2.next;
                n2 = n2.next;
                if(n1.val==head.val) {
                    head.next=n1.next;}
              }
             }
             return head;
         }
     }
 }

