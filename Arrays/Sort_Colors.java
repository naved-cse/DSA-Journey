// Problem: Sort Colors (LeetCode 75)
// Difficulty: Medium
// Approach: I applied the Dutch National Flag algorithm using three pointers: low, mid, and high. The mid pointer
// scans the array, and based on the value, swaps elements to their correct regions. If it’s 0, swap with low and move
// both forward. If it’s 1, just move mid. If it’s 2, swap with high and move high backward, keeping mid in place to
// recheck the swapped value. This ensures all 0s move left, 2s move right, and 1s stay in the middle in a single pass.

class Solution {
    public void sortColors(int[] nums) {
        // The 3 Pointers Setup
        int low = 0;               // Bookmark for where the next '0' should go
        int mid = 0;               // The Explorer scanning the array
        int high = nums.length - 1; // Bookmark for where the next '2' should go

        // The Explorer keeps walking until he crosses the high bookmark
        while (mid <= high) {

            if (nums[mid] == 0) {
                // RULE 1: The Explorer found a 0 (Red)
                // Swap it to the 'low' bookmark to keep it on the left
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                // Move both forward: 'low' secures the spot, 'mid' keeps exploring
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                // RULE 2: The Explorer found a 1 (White)
                // It's already in the middle where it belongs! Just step over it.
                mid++;
            }
            else if (nums[mid] == 2) {
                // RULE 3: The Explorer found a 2 (Blue)
                // Swap it to the 'high' bookmark to send it to the right
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                // Move 'high' backward to secure the spot.
                // CRITICAL: Notice there is NO mid++ here!
                // The Explorer stands still to check the new number he just received from the swap.
                high--;
            }
        }
    }
}