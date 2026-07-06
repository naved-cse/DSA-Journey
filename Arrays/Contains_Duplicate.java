// Problem: Contains Duplicate (LeetCode 217)
// Difficulty: Easy
// Approach: I used a HashSet to track numbers already seen. While iterating through the array, if adding a number to
// the set failed, it meant the number was already present, so I returned true immediately. If the loop completed
// without finding duplicates, I returned false.

class Solution {
    public boolean containsDuplicate(int[] nums) {

        // creating a HashSet to keep track of numbers we have already seen
        HashSet<Integer> seenNums = new HashSet<>();

        // iterating through each number in the array
        for (int num : nums) {

            // trying to add the number to the set
            // if add returns false, it means the number was already present
            if (!seenNums.add(num)) {

                // duplicate found, return true immediately
                return true;
            }
        }

        // if loop finishes without finding duplicates, return false
        return false;
    }
}