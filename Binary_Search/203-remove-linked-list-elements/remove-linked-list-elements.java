class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // 1. Create the dummy node and point it to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 2. Start our walker AT THE DUMMY NODE
        ListNode current = dummy;
        
        // 3. Loop as long as there is a node in front of us to check
        while (current.next != null) {
            
            // 4. Look one step ahead: Is the NEXT node the target?
            if (current.next.val == val) {
                // BYPASS ALGORITHM: 
                // Skip the next node by pointing to the one after it!
                current.next = current.next.next;
                
                // (Notice we DO NOT move 'current' forward here. 
                // We stay put just in case the new next node is also the target!)
            } 
            else {
                // Safe node! We can safely take a step forward.
                current = current.next;
            }
        }
        
        // 5. Return the real list (ignoring the dummy)
        return dummy.next;
    }
}