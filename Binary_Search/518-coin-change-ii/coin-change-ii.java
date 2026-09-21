class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] will store the number of combinations to make up amount i
        int[] dp = new int[amount + 1];
        
        // Base case: There is 1 way to make an amount of 0 (by choosing no coins)
        dp[0] = 1;
        
        // Loop through each coin first to prevent counting permutations
        for (int coin : coins) {
            // Update the dp array for all amounts greater than or equal to the current coin
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        // Return the total number of combinations for the target amount
        return dp[amount];
    }
}
