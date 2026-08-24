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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to serve as the starting point of our result list
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        
        // Loop continues as long as there are nodes to process in l1 or l2, 
        // or if there's a leftover carry to append at the end
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current values, default to 0 if we've reached the end of a list
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Calculate sum and update carry
            int sum = carry + x + y;
            carry = sum / 10;
            
            // Create a new node with the digit part of the sum and attach it
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            // Move to the next nodes in l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Return the actual head of the result list (skipping the dummy node)
        return dummyHead.next;
    }
}