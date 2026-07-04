// Problem: Product of Array Except Self (LeetCode 238)
// Difficulty: Medium
// Approach: I first built a prefix product array ans where each position stores the product of all elements before it.
// Then I used a variable right to track the product of elements to the right while iterating backwards. At each step,
// I multiplied the prefix product with right to get the final value for that index. This way, every element is replaced
// by the product of all other elements without using division.

class Solution {
    public int[] productExceptSelf(int[] nums) {

        // storing the length of the array
        int n = nums.length;

        // creating the answer array to hold final products
        int[] ans = new int[n];

        // first element has no left product, so set to 1
        ans[0] = 1;

        // building prefix products: each ans[i] stores product of all elements to the left
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // variable to track product of elements to the right
        int right = 1;

        // iterating backwards to multiply right products with left products
        for (int i = n - 1; i >= 0; i--) {

            // multiplying left product (already stored in ans[i]) with right product
            ans[i] = ans[i] * right;

            // updating right product by including current element
            right = right * nums[i];
        }

        // returning the final array where each element is product of all except itself
        return ans;
    }
}