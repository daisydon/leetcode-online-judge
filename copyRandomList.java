/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode copy = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        while (copy != null) {
            RandomListNode p = new RandomListNode(copy.label);
            map.put(copy, p);
            copy = copy.next;
        }
        copy = head;
        while (copy != null) {
            RandomListNode p = map.get(copy);
            p.next = null;
            p.random = null;
            if (copy.next != null) {
                p.next = map.get(copy.next);
            }
            if (copy.random != null) {
                p.random = map.get(copy.random);
            } 
            copy = copy.next;
        }
        return map.get(head);
    }
}