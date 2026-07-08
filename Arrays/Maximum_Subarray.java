// Problem: Maximum Subarray (LeetCode 53)
// Difficulty: Medium
// Approach: I applied Kadane’s Algorithm. I kept a running sum currentSum while iterating through the array. If adding
// the current element made the sum larger than maxSum, I updated maxSum. If currentSum dropped below 0, I reset it to
// 0 since a negative sum would only reduce future subarray totals. At the end, maxSum holds the largest possible
// subarray sum.

class Solution {
    public int maxSubArray(int[] nums) {

        // variable to keep track of the running sum of the current subarray
        int currentSum = 0;

        // initialize maxSum with the first element (handles negative arrays too)
        int maxSum = nums[0];

        // iterating through each element in the array
        for (int i = 0; i < nums.length; i++) {

            // add current element to the running sum
            currentSum += nums[i];

            // update maxSum if currentSum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // if currentSum becomes negative, reset it to 0
            // (because continuing with a negative sum will reduce future totals)
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // return the maximum subarray sum found
        return maxSum;
    }
}