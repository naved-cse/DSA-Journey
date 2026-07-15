class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // 1. The Giant Filing Cabinet
        // Key: The Mailbox Label (String) -> Value: The List of Anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // 2. Process every word one by one
        for (String word : strs) {
            
            // A. Count the coins for this specific word
            int[] counts = new int[26];
            for (char c : word.toCharArray()) {
                counts[c - 'a']++; 
            }
            
            // B. Run it through the Label Maker!
            String folderLabel = Arrays.toString(counts); 
            
            // C. Does this folder exist in our cabinet yet?
            if (!map.containsKey(folderLabel)) {
                // If not, create a brand new, empty folder!
                map.put(folderLabel, new ArrayList<>());
            }
            
            // D. Open the folder and drop the word inside
            map.get(folderLabel).add(word);
        }
        
        // 3. We don't care about the labels anymore. Just return all the folders!
        return new ArrayList<>(map.values());
    }
}