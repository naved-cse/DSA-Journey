// Problem: Replace Elements with Greatest Element on Right Side (LeetCode 1299)
// Difficulty: Easy
// Approach: I started with maxright = -1 because the last element should be replaced with -1.
// Then I iterated backwards through the array, stored the current value, replaced it with maxright,
// and updated maxright whenever the current value was larger.
// This way, each position gets replaced by the greatest element to its right.

class Solution {
    public int[] replaceElements(int[] arr) {

        // starting with -1 because the last element should be replaced with -1
        int maxright = -1;

        // iterating from the end of the array towards the beginning
        for (int i = arr.length - 1; i >= 0; i--) {

            // storing the current element before overwriting it
            int current = arr[i];

            // replacing the current position with the maximum element seen to its right
            arr[i] = maxright;

            // if the current element is greater than the max seen so far
            if (current > maxright) {

                // update maxright to this new larger value
                maxright = current;
            }
        }

        // returning the modified array with replacements done
        return arr;
    }
}
