import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // ==========================================
        // STEP 1: Count the Frequencies
        // ==========================================
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // ==========================================
        // STEP 2: The Bucket Sort Trick
        // ==========================================
        // The array size is s.length() + 1 because if a string has 5 letters, 
        // a character could theoretically appear 5 times (Index 5).
        List<Character>[] buckets = new List[s.length() + 1];
        
        // Loop through our HashMap to place characters into their frequency buckets
        for (char key : counts.keySet()) {
            int freq = counts.get(key); // How many times did it appear?
            
            // If this bucket doesn't exist yet, build it!
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            // Drop the character into the bucket matching its frequency
            buckets[freq].add(key);
        }

        // ==========================================
        // STEP 3: Build the Final String (Read Backwards!)
        // ==========================================
        // StringBuilder is a fast way to glue strings together in Java
        StringBuilder sb = new StringBuilder();
        
        // Start from the highest possible frequency (the end of the array)
        for (int i = buckets.length - 1; i > 0; i--) {
            // If there are characters in this bucket...
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    // We must append the character 'i' times!
                    // (e.g., if 'e' is in bucket 2, we append 'e' two times)
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        // Convert the StringBuilder back into a normal String and return it
        return sb.toString();
    }
}