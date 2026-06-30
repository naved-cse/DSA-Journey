// Problem: Move Zeroes (LeetCode 283)
// Difficulty: Easy
// Approach: I used a pointer `digit` to place non-zero elements in order while scanning the array.
// Each time I found a non-zero, I moved it to the front and advanced the pointer.
// After finishing the pass, I filled the remaining positions with zeroes, ensuring all zeroes are shifted to the end.

class Solution {
    public void moveZeroes(int[] nums) {

        // using target = 0 since we want to move all zeroes
        int target = 0;

        // digit pointer keeps track of where the next non-zero should be placed
        int digit = 0;

        // going through each element in the array
        for (int i = 0; i < nums.length; i++) {

            // if the current element is not zero
            if (nums[i] != target) {

                // place this non-zero element at the digit position
                nums[digit] = nums[i];

                // move digit pointer forward
                digit++;
            }
        }

        // after placing all non-zero elements, fill the rest with zeroes
        while (digit < nums.length) {

            // putting zero at the remaining positions
            nums[digit] = target;

            // move digit pointer forward
            digit++;
        }
    }
}