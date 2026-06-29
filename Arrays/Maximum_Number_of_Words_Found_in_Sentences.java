// Problem: Maximum Number of Words Found in Sentences  (LeetCode 2114)
// Difficulty: Easy
// Approach:Here I started with a variable maxwords to keep track of the largest word count. Then for each sentence,
// I split it into words, counted them, and compared that count with maxwords. If it was bigger, I updated maxwords.
// In the end, it returns the maximum number of words found in any sentence.

class Solution {
    public int mostWordsFound(String[] sentences) {

        // keeping track of the maximum number of words seen so far
        int maxwords = 0;

        // going through each sentence in the array
        for (String s : sentences){

            // splitting the sentence into words using space as separator
            String[] words = s.split(" ");

            // counting how many words are in this sentence
            int wordcount = words.length;

            // checking if this sentence has more words than the current maximum
            if (wordcount > maxwords){

                // updating maxwords to this new larger count
                maxwords = wordcount;
            }
        }

        // finally returning the largest word count found among all sentences
        return maxwords;
    }
}
