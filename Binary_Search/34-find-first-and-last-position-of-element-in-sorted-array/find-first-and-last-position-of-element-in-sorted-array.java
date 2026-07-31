class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = -1;
        int lastPos = -1;

        // ==========================================
        // LOOP 1: Find the FIRST position
        // ==========================================
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPos = mid;     // Save it!
                right = mid - 1;    // Keep chopping off the right to hunt LEFT
            } 
            else if (nums[mid] > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        // ==========================================
        // LOOP 2: Find the LAST position
        // ==========================================
        // We MUST reset our pointers back to the start and end of the array!
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPos = mid;      // Save it!
                left = mid + 1;     // Keep chopping off the left to hunt RIGHT
            } 
            else if (nums[mid] > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        // Return our two answers!
        return new int[]{firstPos, lastPos};
    }
}