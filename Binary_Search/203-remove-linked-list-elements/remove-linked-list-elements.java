/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head of the list.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // Use a current pointer starting at the dummy node.
        ListNode curr = dummy;
        
        // Traverse the list
        while (curr.next != null) {
            // If the next node needs to be removed
            if (curr.next.val == val) {
                // Skip the next node
                curr.next = curr.next.next;
            } else {
                // Otherwise, just move the pointer forward
                curr = curr.next;
            }
        }
        
        // Return the new head, which is the node after the dummy
        return dummy.next;
    }
}