// Problem: Shuffle the Array (LeetCode 1470)
// Difficulty: Easy
// Approach: I created a new array `result` to store the shuffled values.
// Then I looped from 0 to n, and for each index, I placed the element from the first half at position `i*2`
// and the element from the second half at position `i*2+1`.
// This way, the array gets rearranged in the required interleaving pattern.

class Solution {
    public int[] shuffle(int[] nums, int n) {

        // creating a new array to store the shuffled result
        int[] result = new int[nums.length];

        // looping from 0 to n to handle both halves of the array
        for (int i = 0; i < n; i++) {

            // placing the element from the first half at even positions
            result[i * 2] = nums[i];

            // placing the element from the second half at odd positions
            result[i * 2 + 1] = nums[i + n];
        }

        // returning the final interleaved array
        return result;
    }
}
