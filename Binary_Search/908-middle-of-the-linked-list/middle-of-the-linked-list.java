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
    public ListNode middleNode(ListNode head) {
        // Initialize both pointers at the head of the list
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer 1 step
            fast = fast.next.next;  // Move fast pointer 2 steps
        }
        
        // Slow is now pointing to the middle node
        return slow;
    }
}