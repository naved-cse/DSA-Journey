class Solution {
    public int rob(int[] nums) {
        // Edge cases: handle empty streets or a single house
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 1. The "Notepad" (DP Array)
        // dp[i] represents the absolute maximum money you can have when standing at house 'i'
        int[] dp = new int[nums.length];

        // 2. The Base Cases (Setting up the foundation)
        dp[0] = nums[0]; // If there's only one house, your max profit is just robbing it
        dp[1] = Math.max(nums[0], nums[1]); // If there are two, you rob the richer one

        // 3. The Recurrence Relation (Filling out the notepad)
        for (int i = 2; i < nums.length; i++) {
            // Option A: Skip this house. Total stays the same as the previous house (dp[i-1]).
            // Option B: Rob this house. Add its money (nums[i]) to the max profit from two houses back (dp[i-2]).
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]); 
        }

        // The very last entry in our notepad holds the optimal answer for the entire street
        return dp[nums.length - 1];
    }
}
