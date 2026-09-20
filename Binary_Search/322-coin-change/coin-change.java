import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1. The Notepad
        // Size is amount + 1 because we need an index for amount 0 all the way up to 'amount'
        int[] dp = new int[amount + 1];
        
        // 2. The Baseline (Fill with a number higher than any possible answer)
        int max = amount + 1; 
        Arrays.fill(dp, max);
        
        // Base case: It takes 0 coins to make $0
        dp[0] = 0; 
        
        // 3. The Outer Loop (Building up the amounts step-by-step)
        for (int i = 1; i <= amount; i++) {
            
            // 4. The Inner Loop (Trying every available coin)
            for (int j = 0; j < coins.length; j++) {
                
                // If the coin is smaller than or equal to the current amount we are trying to make...
                if (coins[j] <= i) {
                    
                    // ...try using this coin! 
                    // Equation: 1 (this coin) + whatever the best answer was for the remaining amount (i - coins[j])
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        // 5. The Verdict
        // If the target amount slot still has our artificial 'max' value, it means it was impossible to make!
        if (dp[amount] > amount) {
            return -1; 
        } else {
            return dp[amount];
        }
    }
}