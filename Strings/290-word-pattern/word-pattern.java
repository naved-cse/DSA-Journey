class Solution {
    public boolean wordPattern(String pattern, String s) {
        // 1. The Chop: Turn the string into an array of words
        String[] words = s.split(" ");
        
        // 2. The Boundary Check: Do we have a 1-to-1 match of items?
        if (pattern.length() != words.length) {
            return false;
        }
        
        // 3. The Two Tools
        Map<Character, String> rulebook = new HashMap<>();
        Set<String> claimedWords = new HashSet<>();
        
        // 4. The Iteration
        for (int i = 0; i < pattern.length(); i++) {
            char charS = pattern.charAt(i); // The letter
            String wordT = words[i];        // The whole word!
            
            // SCENARIO A: We already have a rule for this letter
            if (rulebook.containsKey(charS)) {
                // Check if the saved word matches the current word
                if (!rulebook.get(charS).equals(wordT)) {
                    return false;
                }
            } 
            // SCENARIO B: Brand new letter!
            else {
                // Has this word already been claimed by another letter?
                if (claimedWords.contains(wordT)) {
                    return false;
                }
                
                // Safe! Write the rule and claim the word.
                rulebook.put(charS, wordT);
                claimedWords.add(wordT);
            }
        }        
        return true;
    }
}