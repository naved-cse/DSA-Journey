class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 1. Your brilliant initial boundary condition!
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 2. The Magazine Mailbox (Our pile of letter cutouts)
        int[] counts = new int[26];
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++; // counts++ using mailbox rules!
        }

        // 3. The Subtracting Logic (Cutting letters out for the Ransom Note)
        for (char c : ransomNote.toCharArray()) {
            int mailboxIndex = c - 'a';
            
            // Cut the letter from the magazine pile
            counts[mailboxIndex]--;

            // THE ALARM! 🚨 
            // If the count drops below 0, we used a letter we didn't have!
            if (counts[mailboxIndex] < 0) {
                return false; 
            }
        }

        // If we successfully matched every letter, we can make the note!
        return true;
    }
}