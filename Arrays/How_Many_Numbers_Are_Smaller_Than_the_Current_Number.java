// Problem: How Many Numbers Are Smaller Than the Current Number (LeetCode 1365)
// Difficulty: Easy
// Approach: I created a result array to store counts for each element. For every number in nums, I compared it with
// all other elements and kept a counter smaller to track how many values were less than it. After finishing the inner
// loop, I stored that count in the result array. In the end, the result array contains the count of smaller numbers
// for each position.

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // creating a result array to store counts for each element
        int[] result = new int[nums.length];

        // iterating through each element in nums
        for (int i = 0; i < nums.length; i++) {

            // counter to track how many numbers are smaller than nums[i]
            int smaller = 0;

            // comparing nums[i] with every other element
            for (int j = 0; j < nums.length; j++) {

                // if nums[i] is greater than nums[j], increase the smaller count
                if (nums[i] > nums[j]) {
                    smaller++;
                }

                // storing the count of smaller numbers for this index
                result[i] = smaller;
            }
        }

        // returning the final array with counts
        return result;
    }
}