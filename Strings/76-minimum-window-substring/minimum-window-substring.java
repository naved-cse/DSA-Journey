class Solution {
    public String minWindow(String s, String t) {
        // Edge Case: If t is bigger than s, it's impossible!
        if (s.length() < t.length() || t.equals("")) return "";

        // 1. Setup the 128 Mailboxes
        int[] targetBox = new int[128];
        int[] windowBox = new int[128];

        // Fill the target mailboxes with our required letters
        for (char c : t.toCharArray()) {
            targetBox[c]++;
        }

        int left = 0;
        int matchedCoins = 0;           // How many USEFUL coins we have found
        int requiredCoins = t.length(); // How many total coins we NEED
        
        // Variables to remember our all-time best minimum window
        int minLength = Integer.MAX_VALUE;
        int bestStart = 0; 

        // 2. Expand the right side of the window
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            // Drop the coin in the window mailbox
            windowBox[rightChar]++;

            // Is this a USEFUL coin? 
            // (Is the amount we have <= the amount we need?)
            if (windowBox[rightChar] <= targetBox[rightChar]) {
                matchedCoins++;
            }

            // 3. THE SHRINKING PHASE
            // If matchedCoins == requiredCoins, our window is VALID!
            while (matchedCoins == requiredCoins) {
                
                // A. Is this the smallest valid window we've ever seen?
                int currentWindowSize = right - left + 1;
                if (currentWindowSize < minLength) {
                    minLength = currentWindowSize;
                    bestStart = left; // Remember where this winning string starts!
                }

                // B. Time to shrink! Look at the left character
                char leftChar = s.charAt(left);
                
                // Take its coin OUT of the window mailbox
                windowBox[leftChar]--;

                // C. THE TRUE SHRINKING RULE 🚨
                // Did taking that coin out BREAK our window? 
                // (Do we now have LESS than what the target needs?)
                if (windowBox[leftChar] < targetBox[leftChar]) {
                    matchedCoins--; // We lost a required coin! The window is now invalid.
                }

                // D. Actually move the left pointer forward
                left++;
            }
        }

        // 4. Return the result!
        // If minLength never changed, we never found a valid window.
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        
        // Otherwise, cut the winning substring out of 's' and return it!
        return s.substring(bestStart, bestStart + minLength);
    }
}