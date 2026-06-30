// Problem: Squares of a Sorted Array (LeetCode 977)
// Difficulty: Easy
// Approach: I used two pointers, one at the start and one at the end, to compare squares of both sides.
// The larger square was placed at the current highest index in the result array, and then I moved the pointer accordingly.
// This way, the result array gets filled in descending order from the back, ensuring the final output is sorted.

class Solution {
    public int[] sortedSquares(int[] nums) {

        // storing the length of the array for later use
        int n = nums.length;

        // creating a new array to hold the squared and sorted values
        int[] result = new int[n];

        // setting two pointers: one at the start and one at the end
        int left = 0;
        int right = n - 1;

        // filling the result array from the back since we place the largest squares first
        for (int i = n - 1; i >= 0; i--) {

            // squaring the value at the left pointer
            int leftsquare = nums[left] * nums[left];

            // squaring the value at the right pointer
            int rightsquare = nums[right] * nums[right];

            // if the left square is bigger, place it at the current position
            if (leftsquare > rightsquare) {
                result[i] = leftsquare;
                left++;  // move left pointer forward
            }
            else {
                // otherwise place the right square and move right pointer backward
                result[i] = rightsquare;
                right--;
            }
        }

        // returning the sorted squares array
        return result;
    }
}