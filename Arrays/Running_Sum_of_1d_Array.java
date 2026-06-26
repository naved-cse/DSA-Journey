// Problem: Running Sum of 1d Array (LeetCode 1480)
// Difficulty: Easy
// Approach: This code uses a cumulative approach: you keep a running total in runningSum,
// add each element of the input array one by one, and store the updated sum in the result
// array. The process reflects a clear loop-based strategy — initialize, update, and
// record — so each position in result shows the sum of all elements up to that index.


class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int runningSum = 0;
        for (int i=0; i < nums.length; i++){
            runningSum += nums[i];
            result[i] = runningSum;
        }
        return result;
    }
}