class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // ==========================================
        // PHASE 1: Find the Middle (Tortoise & Hare)
        // ==========================================
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // ==========================================
        // PHASE 2: Reverse the Second Half
        // ==========================================
        ListNode prev = null;
        ListNode curr = slow; // Start reversing from the middle!
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Bookmark
            curr.next = prev;              // Unplug and point backward
            prev = curr;                   // Slide prev
            curr = nextTemp;               // Slide curr
        }
        
        // ==========================================
        // PHASE 3: Compare the Two Halves
        // ==========================================
        ListNode left = head;  // Starts at the very beginning
        ListNode right = prev; // 'prev' is standing on the very last node!
        
        // Walk until the reversed right half runs out of nodes
        while (right != null) {
            
            if (left.val != right.val) {
                return false; // Mismatch! Not a palindrome.
            }
            
            // They matched! Step them both forward.
            left = left.next;
            right = right.next;
        }
        
        // If the loop finished without returning false, it's a palindrome!
        return true; 
    }
}