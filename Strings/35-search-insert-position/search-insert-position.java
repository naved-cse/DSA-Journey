class Solution {
    public int searchInsert(int[] nums, int target) {
        // 1. Initialize left and right
        int left = 0;
        int right = nums.length - 1;

        // 2. Loop while left <= right
        while (left <= right) {
            
            // 3. Find the mid safely
            int mid = left + (right - left) / 2;

            // 4. The if statements
            if (nums[mid] == target) {
                return mid; // Found it!
            } 
            else if (nums[mid] > target) {
                // If the number at mid is too big, target is on the left
                right = mid - 1;
            } 
            else {
                // If the number at mid is too small, target is on the right
                left = mid + 1; 
            }
        }

        // 5. If nothing matches, left is standing exactly where the number belongs
        return left;
    }
}