package chapter2;

public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode duplicate = head.next; 
        while(duplicate!=null){
            if(current.data == duplicate.data){
            	if(duplicate.next!=null){
            		if(duplicate.data == duplicate.next.data){
            			current.next = duplicate.next;
            			duplicate = duplicate.next;
            		}
            		else{
            			if(dummy.next == head){
            			head = duplicate.next;
            			dummy.next = head;
            			current = duplicate.next;
            			 if(duplicate.next.next==null) break;
            			 else duplicate = duplicate.next.next;
            			}
            			else{	
            			current = duplicate.next;
            			dummy.next = current;
            			if(duplicate.next.next==null) break;
            			else duplicate = duplicate.next.next;
            			}	
            		}
            	}
            	else{
            		if(dummy.next == head){
            			head = null;
            			dummy.next = head;
            		}
            		else{
            			dummy.next = null;
            			duplicate = null;
            		}
            	}
            }
            else{
            	dummy = dummy.next;
            	current = current.next;
            	duplicate = duplicate.next;
            }
        }
        return head;
    }
}
