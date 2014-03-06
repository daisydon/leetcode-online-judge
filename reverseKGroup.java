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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;          //keep track of the tail of reversed group
        ListNode s = head;
        ListNode e = head;
        int counter = 1;
        while (e != null) {
            if (counter % k == 0) {
                //move the s, e to the node to the next reverse group
                ListNode start = s;
                ListNode end = e;
                s = e.next;
                e = e.next;
                counter++;
                //reverse linkedlist
                ListNode before = null;
                ListNode cur = null;
                ListNode tail = start;        //tail should not be null (cases: k = 1, start == end)
                
                while (start != end) {
                    cur = start;
                    start = start.next;
                    cur.next = before;
                    if (before == null) tail = cur;
                    before = cur;
                }
                end.next = before;      
                pre.next = end;         //head of newly reversed linkedlist
                pre = tail;             //update pre to the tail of newly reversed linkedlist
            }
            else {
                e = e.next;
                if (e == null && counter % k != 0) pre.next = s;    //pay attention here!!
                else counter++;
            }
        }
        return dummy.next;
    }
}