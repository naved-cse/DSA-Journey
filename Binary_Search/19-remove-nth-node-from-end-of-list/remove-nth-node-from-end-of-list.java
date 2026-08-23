class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // 1. Create the Dummy Node (our shield against the head-deletion edge case!)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 2. Start both pointers at the dummy
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // 3. Create the gap! Move 'fast' forward exactly N times
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // 4. Walk them both forward until 'fast' lands on the very last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 5. BOOM! 'slow' is now sitting right in front of the target node.
        // Bypass the target node!
        slow.next = slow.next.next;
        
        // 6. Return the real list (ignoring the dummy)
        return dummy.next;
    }
}