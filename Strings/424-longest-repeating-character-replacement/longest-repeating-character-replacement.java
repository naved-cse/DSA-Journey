class Solution {
    public int characterReplacement(String s, int k) {
        // ==========================================
        // STEP 1: The Setup
        // ==========================================
        int[] counts = new int[26]; // Our 26 mailboxes (Indices 0-25 represent A-Z)
        int left = 0;               // The back edge of our sliding window
        int popularCount = 0;       // The highest number of coins in any single mailbox
        int maxLength = 0;          // Our high score (the widest valid window we find)

        // ==========================================
        // STEP 2: Expanding the Window (Moving 'right')
        // ==========================================
        for (int right = 0; right < s.length(); right++) {
            
            // 1. A new letter enters the right side of the window. 
            // Calculate its mailbox number (e.g., 'A' - 'A' = 0, 'B' - 'A' = 1)
            int rightBox = s.charAt(right) - 'A';
            
            // Drop a coin in that specific mailbox
            counts[rightBox]++;

            // 2. Did this new coin make this letter the new King?
            popularCount = Math.max(popularCount, counts[rightBox]);

            // ==========================================
            // STEP 3: The Shrinking Phase (The Magic Formula)
            // ==========================================
            // (right - left + 1) -> This is our total Window Size.
            // Window Size - popularCount -> This gives us the number of "Trash Letters"
            // If Trash Letters > k, our window is INVALID. We must shrink it!
            while ((right - left + 1) - popularCount > k) {
                
                // Find the mailbox for the letter at the 'left' edge
                int leftBox = s.charAt(left) - 'A';
                
                // Take a coin OUT of its mailbox because it is falling out of the window
                counts[leftBox]--;

                // Shrink the window by pulling the left edge forward
                left++;
            }

            // ==========================================
            // STEP 4: Record the Score
            // ==========================================
            // If we made it here, the window is officially VALID. 
            // Is this the biggest valid window we have seen so far?
            maxLength = Math.max(maxLength, right - left + 1); 
        }
        
        return maxLength;
    }
}