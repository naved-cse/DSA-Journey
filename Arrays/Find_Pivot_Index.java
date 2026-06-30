// Problem: Find Pivot Index (LeetCode 724)
// Difficulty: Easy
// Approach: First I calculated the total sum of the array. Then I kept a running left sum while iterating through each index.
// At every step, I checked if the left sum equals the right sum (which is total minus left minus current element).
// If they matched, that index was the pivot. Otherwise, I updated the left sum and continued.
// If no pivot was found, I returned -1.

class Solution {
    public int pivotIndex(int[] nums) {

        // calculating the total sum of all elements in the array
        int total = 0;
        for (int num : nums)
            total += num;

        // starting with left sum as 0
        int left = 0;

        // iterating through each index to check if it can be the pivot
        for (int i = 0; i < nums.length; i++) {

            // right sum is total minus left sum minus the current element
            int right = total - left - nums[i];

            // if left sum equals right sum, this index is the pivot
            if (left == right) {
                return i;
            }

            // updating left sum by adding the current element
            left += nums[i];
        }

        // if no pivot index is found, return -1
        return -1;
    }
}