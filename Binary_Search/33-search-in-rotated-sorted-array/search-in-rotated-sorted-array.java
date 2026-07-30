class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 1. Find the safe mid
            int mid = left + (right - left) / 2;

            // 2. Did we find it?
            if (nums[mid] == target) {
                return mid;
            }

            // 3. Which half is the "Perfectly Sorted" half?
            
            // Scenario A: Left half is perfectly sorted
            if (nums[left] <= nums[mid]) {
                // Is the target inside this sorted left half?
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Yes! Discard the right side.
                } else {
                    left = mid + 1;  // No! Discard the left side.
                }
            } 
            
            // Scenario B: Right half is perfectly sorted
            else {
                // Is the target inside this sorted right half?
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Yes! Discard the left side.
                } else {
                    right = mid - 1; // No! Discard the right side.
                }
            }
        }

        // 4. Target is not in the array
        return -1;
    }
}