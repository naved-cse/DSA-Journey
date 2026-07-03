// Problem: Left and Right Sum Differences (LeetCode 2574)
// Difficulty: Easy
// Approach: First I calculated the total sum of the array. Then while iterating, I used it to find the right sum as
// totalsum - leftsum - nums[i]. I stored the absolute difference between left and right sums in the answer array,
// and finally updated leftsum by adding the current element. This way, each index gets its left-right difference
// efficiently.

class Solution {
    public int[] leftRightDifference(int[] nums) {

        // variable to keep track of sum of elements on the left side
        int leftsum = 0;

        // variable to keep track of sum of elements on the right side
        int rightsum = 0;

        // calculating the total sum of the array first
        int totalsum = 0;
        for (int n : nums)
            totalsum += n;

        // creating the answer array to store differences for each index
        int[] answer = new int[nums.length];

        // iterating through each index
        for (int i = 0; i < nums.length; i++) {

            // right sum is total minus left sum minus current element
            rightsum = totalsum - leftsum - nums[i];

            // storing the absolute difference between left and right sums
            answer[i] = Math.abs(leftsum - rightsum);

            // updating left sum by adding the current element
            leftsum += nums[i];
        }

        // returning the final array with differences
        return answer;
    }
}