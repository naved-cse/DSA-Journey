// Problem: Build Array from Permutation (LeetCode 1920)
// Difficulty: Easy
// Approach:Here I first created a new array ans to store the result. Then I looped through each index and used the value
// at that index as a pointer to another position in the same array. Finally, I set ans[i] = nums[nums[i]], so each element
// in ans is built by following the mapping defined in nums.

class Solution {
    public int[] buildArray(int[] nums) {

        // Creating a new array to store the result
        int[] ans = new int[nums.length];

        // Loop through each index of the array
        for (int i = 0; i < nums.length; i++) {

            // Using value at index i as a new index
            // and storing nums[nums[i]] into ans[i]
            ans[i] = nums[nums[i]];
        }

        // Returning the final built array
        return ans;
    }
}