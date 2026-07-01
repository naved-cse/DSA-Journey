// Problem: Range Sum Query - Immutable (LeetCode 303)
// Difficulty: Easy
// Approach: I created a prefix sum array sumindex with one extra slot to simplify calculations. Each index stores the
// sum of elements up to that point. Then for any range query, I quickly get the sum in O(1) by subtracting the prefix
// sum up to left from the prefix sum up to right+1.

class NumArray {
    // array to store prefix sums for quick range queries
    private int[] sumindex;

    public NumArray(int[] nums) {
        // creating prefix sum array with one extra space for easier calculations
        sumindex = new int[nums.length + 1];

        // building prefix sums: each position stores sum up to that index
        for (int i = 0; i < nums.length; i++) {
            sumindex[i + 1] = sumindex[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // using prefix sums to get range sum in O(1):
        // subtract sum up to left from sum up to right+1
        return sumindex[right + 1] - sumindex[left];
    }
}