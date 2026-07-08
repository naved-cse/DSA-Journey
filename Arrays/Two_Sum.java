// Problem: Two Sum (LeetCode 1)
// Difficulty: Easy
// Approach: I used a HashMap to store numbers and their indices as I iterated through the array. For each number,
// I calculated its complement (target - nums[i]) and checked if it was already in the map. If found, I returned the
// indices of the complement and the current number. Otherwise, I added the current number to the map. This ensures the
// solution is found in a single pass with O(n) time complexity.

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // using a HashMap to store numbers and their indices for quick lookup
        HashMap<Integer, Integer> map = new HashMap<>();

        // iterating through each number in the array
        for (int i = 0; i < nums.length; i++) {

            // calculating the complement needed to reach the target
            int compliment = target - nums[i];

            // if the complement is already in the map, we found the pair
            if (map.containsKey(compliment)) {

                // return the indices of the complement and current number
                return new int[] { map.get(compliment), i };
            }

            // otherwise, store the current number with its index in the map
            map.put(nums[i], i);
        }

        // if no pair is found, return an empty array
        return new int[] {};
    }
}