class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        
        // dp[i] will store true if a subset sum of i is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: a sum of 0 is always possible

        // Process each number in the array
        for (int num : nums) {
            // Iterate backwards to avoid using the current number multiple times
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            
            // Optimization: If we found a valid partition early, return true
            if (dp[target]) {
                return true;
            }
        }

        return dp[target];
    }
}
