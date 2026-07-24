class Solution {
    public int strStr(String haystack, String needle) {
        // 1. Base cases
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        // 2. THE ANCHOR LOOP
        // We stop early because if the remaining letters are shorter 
        // than the needle, it's physically impossible to find a match!
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            int j = 0; // The Scout starts at the beginning of the needle
            
            // 3. THE SCOUT LOOP
            while (j < needle.length()) {
                // If there's a mismatch, sound the alarm and stop!
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; 
                }
                // If it matched, the Scout takes a step forward
                j++;
            }

            // 4. Did the Scout make it through the entire needle?
            if (j == needle.length()) {
                return i; // We found the whole word! Return the Anchor's position.
            }
        }

        // 5. The Anchor checked everywhere and found nothing
        return -1;
    }
}