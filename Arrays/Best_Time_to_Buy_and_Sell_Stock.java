// Problem: Best Time to Buy and Sell Stock (LeetCode 121)
// Difficulty: Easy
// Approach: I started with min as the first price to track the lowest value seen so far and max as 0 to store the
// best profit. Then while iterating, if I found a smaller price, I updated min. Otherwise, I checked if selling at
// the current price gave a better profit than max and updated it. In the end, max holds the maximum profit achievable.

class Solution {
    public int maxProfit(int[] prices) {

        // starting with the first price as the minimum seen so far
        int min = prices[0];

        // variable to store the maximum profit found
        int max = 0;

        // iterating through each price
        for (int i = 0; i < prices.length; i++) {

            // if the current price is smaller than the minimum, update min
            if (prices[i] < min) {
                min = prices[i];
            }

            // otherwise check if selling at current price gives better profit
            else if (prices[i] - min > max) {

                // update max profit to this new larger value
                max = prices[i] - min;
            }
        }

        // returning the maximum profit achievable
        return max;
    }
}