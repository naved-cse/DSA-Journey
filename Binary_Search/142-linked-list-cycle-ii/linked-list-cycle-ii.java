public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Start both runners at the beginning of the maze
        ListNode slow = head;
        ListNode fast = head;
        
        // ==========================================
        // PHASE 1: Find the Crash Site
        // ==========================================
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step
            fast = fast.next.next;    // 2 steps
            
            // If they land on the exact same node, we found a cycle!
            if (slow == fast) {
                
                // ==========================================
                // PHASE 2: The Reset
                // ==========================================
                // Pick up the fast pointer and put it all the way back at the start
                fast = head;
                
                // ==========================================
                // PHASE 3: The Walk
                // ==========================================
                // Now, they BOTH walk 1 step at a time.
                // The math guarantees they will bump into each other at the loop's start!
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // They bumped! Return the node where the cycle begins.
                return slow; 
            }
        }
        
        // If the while loop finishes, the fast pointer hit a dead end (null).
        // That means there is no cycle at all.
        return null;
    }
}