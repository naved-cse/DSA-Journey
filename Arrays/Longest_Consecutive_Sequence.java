// Problem: Longest Consecutive Sequence (LeetCode 128)
// Difficulty: Medium
// Approach: I stored all numbers in a HashSet for quick lookup. Then for each number, I only started counting if it was
// the beginning of a sequence (i.e., n-1 not present). From there, I extended the streak by checking consecutive
// numbers (start+1) until the sequence ended. I updated max with the longest streak found. This ensures O(n) time
// complexity since each number is processed at most once.

class Solution {
    public int longestConsecutive(int[] nums) {

        // using a HashSet to store all numbers for O(1) lookup
        HashSet<Integer> set = new HashSet<>();

        // variable to track the longest consecutive streak found
        int max = 0;

        // add all numbers into the set
        for (int n : nums) set.add(n);

        // iterate through each number in the set
        for (int n : set) {

            // check if n is the start of a sequence (no smaller consecutive number exists)
            if (!set.contains(n - 1)) {

                // start building the streak from n
                int start = n;
                int streak = 1;

                // keep extending the streak while consecutive numbers exist
                while (set.contains(start + 1)) {
                    streak++;
                    start++;
                }

                // update max streak if this one is longer
                max = Math.max(max, streak);
            }
        }

        // return the longest consecutive sequence length
        return max;
    }