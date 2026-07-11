class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge Case: If s1 is bigger than s2, a permutation is impossible!
        if (s1.length() > s2.length()) return false;
        
        // 1. Create our two sets of 26 Mailboxes
        int[] s1Counts = new int[26];
        int[] windowCounts = new int[26];
        
        // 2. Build the Target Mailboxes AND the First Window at the same time
        int windowSize = s1.length();
        for (int i = 0; i < windowSize; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            // creating it for checking and comparing 2 window
            windowCounts[s2.charAt(i) - 'a']++;
        }
        
        // 3. Slide the Steel Window across the rest of s2!
        for (int right = windowSize; right < s2.length(); right++) {
            
            // Check if our current window is a match!
            if (Arrays.equals(s1Counts, windowCounts)) {
                return true; 
            }
            
            // It didn't match. Time to SLIDE THE WINDOW right by 1 step.
            
            // A. Add the new character on the right
            windowCounts[s2.charAt(right) - 'a']++;
            
            // B. Calculate who fell out of the left side
            int left = right - windowSize;
            
            // C. Remove the left character's coin
            windowCounts[s2.charAt(left) - 'a']--;
        }
        
        // Don't forget to check the very last window after the loop finishes!
        return Arrays.equals(s1Counts, windowCounts);
    }
}