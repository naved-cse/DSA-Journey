// Problem: Best Time to Buy and Sell Stock II (LeetCode 122)
// Difficulty: Medium
// Approach: I tracked profit by checking consecutive days. If today’s price was higher than yesterday’s, I added the
// difference to profit, simulating a buy on the previous day and a sell on the current day. This way, I accumulated all
// possible gains across multiple transactions, and the final profit represents the maximum achievable.

class Solution {
    public int maxProfit(int[] prices) {

        // variable to accumulate total profit across multiple transactions
        int profit = 0;

        // starting from the second day and comparing with the previous day
        for (int i = 1; i < prices.length; i++) {

            // if today's price is higher than yesterday's
            if (prices[i] > prices[i - 1]) {

                // add the difference to profit (buy yesterday, sell today)
                profit += prices[i] - prices[i - 1];
            }
        }

        // returning the total profit after all possible transactions
        return profit;
    }
}