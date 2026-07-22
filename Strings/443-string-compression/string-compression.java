class Solution {
    public int compress(char[] chars) {
        int read = 0;  // The fast finger that counts
        int write = 0; // The slow finger that overwrites

        // Loop until we have checked every single letter
        while (read < chars.length) {
            
            // 1. Lock in the character we are looking at
            char currentChar = chars[read];
            int count = 0;

            // 2. THE READ FINGER: Count all matching characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;  // Move forward
                count++; // Tally it up
            }

            // 3. THE WRITE FINGER: Scribble the letter
            chars[write] = currentChar; 
            write++; // Move the write finger forward

            // 4. THE WRITE FINGER: Scribble the number (if greater than 1)
            if (count > 1) {
                // Turn the number (like 12) into a String ("12")
                String countStr = String.valueOf(count);
                
                // Write each digit one by one
                for (char c : countStr.toCharArray()) {
                    chars[write] = c;
                    write++; // Move the write finger forward
                }
            }
        }

        // The write finger's position is exactly the length of our new compressed string!
        return write;
    }
}