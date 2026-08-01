class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // We use < instead of <= because we use right = mid
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Look at the slope to our right
            if (nums[mid] < nums[mid + 1]) {
                // The ground goes UP! The peak must be to the right.
                // mid is definitely NOT the peak, so we can throw it away.
                left = mid + 1;
            } else {
                // The ground goes DOWN! 
                // The peak is either mid itself, or somewhere to the left.
                right = mid;
            }
        }

        // When the loop breaks, left and right are standing on the exact same spot.
        // That spot is our guaranteed peak!
        return left;
    }
}