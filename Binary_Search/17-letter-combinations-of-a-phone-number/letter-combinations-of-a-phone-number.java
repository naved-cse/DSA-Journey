class Solution {
    // 1. THE SETUP: The phone keypad mapping we discussed
    private static final String[] phoneMap = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // EDGE CASE GUARD: If they give us an empty string "", return empty list instantly.
        // If we don't do this, our code will return [""] instead of [], which fails LeetCode!
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start the factory at index 0 of the digits string
        backtrack(result, new StringBuilder(), digits, 0);
        
        return result;
    }

    private void backtrack(List<String> result, StringBuilder bucket, String digits, int index) {
        
        // BASE CASE: The Photographer
        // Take the photo ONLY when the bucket length matches the input digits length
        if (bucket.length() == digits.length()) {
            result.add(bucket.toString()); // Convert StringBuilder back to a regular String
            return;
        }

        // FIND THE RIGHT LETTERS TO LOOP THROUGH
        // 1. Get the current digit character (e.g., '2')
        char currentDigit = digits.charAt(index);
        // 2. Convert the character '2' into the integer 2 (by subtracting ASCII '0')
        int mapIndex = currentDigit - '0';
        // 3. Grab the letters from our map (e.g., "abc")
        String letters = phoneMap[mapIndex];

        // THE DYNAMIC LOOP
        // Loop through 'a', then 'b', then 'c'
        for (int i = 0; i < letters.length(); i++) {
            
            char chosenLetter = letters.charAt(i);
            
            // A. CHOOSE: Drop the letter in the bucket
            bucket.append(chosenLetter);
            
            // B. EXPLORE: Throw the boomerang to the NEXT digit in the input (index + 1)
            backtrack(result, bucket, digits, index + 1);
            
            // C. UN-CHOOSE: Pull the letter back out of the bucket
            bucket.deleteCharAt(bucket.length() - 1);
        }
    }
}