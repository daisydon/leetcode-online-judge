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
    //*Method 1: Stupid, iterate linked list twice
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        if(head.next==null&&n>1) return null;
        
        int counter=0;
        ListNode pointer= new ListNode(head.val);
        pointer.next=head.next;
        
        ListNode p2= new ListNode(head.val);      //point to the node before the delete node
        p2.next=head.next;
         
        ListNode p3= new ListNode(head.next.val); //point to the delete node
        p3.next =head.next.next;
       
        while(pointer.next!=null){
            counter++;
        }
        int i=1;
        while(i<counter-n+1){
         
            p2 = p2.next;             
            p3 = p3.next;
            i++; }
        if(head==p2){
            head.next=p3.next;
        }
        else{
            p2.next=p3.next;
        }
    return head;      
    }

    //Method2: use three pointers
    //has some cases that do not work
    public ListNode removeNode(ListNode head, int n){
         if(head == null) return null;
         if(head.next == null && n>=1) return null;
         if(head.next.next ==null){      
           if (n==1) 
           {head.next =null; return head;}
           else if(n==2) 
           {head = head.next; return head;}
         } 
         
         
        ListNode p1 = new ListNode(head.val);     //point to the (n-1)th node from the end of linked list
        p1.next = head.next;

        ListNode p2 = new ListNode(p1.next.val);   //point to the nth node from the end of linked list
        p2.next = p1.next.next;

        ListNode p3 = new ListNode(p2.next.val);  //point to the last node of the linked list
        p3.next = p2.next.next; 
         if(p3.next ==null) {
            if (n==1) {p2.next=p3.next;return head;}
            else if(n==2) {
                head.next =p2.next;
                return head;
            }
            else if(n==3){
                head.val=p2.val;
                head.next=p2.next;
                return head;
            }
        }
        int i=1;
        while(i<n-1){
            i++;
            p3 = p3.next;
         }
        while(p3.next!=null){
           p1=p1.next;
           p2=p2.next;
           p3=p3.next;
         }
        p1.next = p2.next;
        if(p1==head) {
            head.next = p1.next;
        }
        return head;
       }

//Method3: use two pointers
//AC
    public ListNode removeNthNode(ListNode head, int n){        if(head == null) return null;
         if(head.next==null&&n>=1) return null;
         if(head.next.next==null&&n==1) {head.next =null; return head;}
        
   
        ListNode p1 = head;      //point to the (n+1)th node from the end of linked list
        
        ListNode p2 = head;     //point to the last node of linked list

        int i =0;
        while(i<n){
          p2=p2.next;
          i++;
        }
        
        if ( p2 == null ){             //if head is the nth node from the end
            return head.next;
        }
      
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        
        if(p1==head){                 //if head is the (n+1)th node from the end
            head.next=p1.next.next;
            return head;
        }
        else{
          p1.next=p1.next.next;
          return head;
        }
    }
}
        
