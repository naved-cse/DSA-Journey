class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 1. The Notepad
        int[] dp = new int[nums.length];
        
        // 2. The Baseline: Every number is a valid sequence of length 1 by itself
        Arrays.fill(dp, 1); 
        
        int maxSequence = 1; // To track the absolute biggest number we find

        // 3. The Outer Loop (The Current Number)
        for (int i = 1; i < nums.length; i++) {
            
            // 4. The Inner Loop (Looking backward at history)
            for (int j = 0; j < i; j++) {
                
                // If the current number is bigger than the previous number we are looking at...
                if (nums[i] > nums[j]) {
                    // ...attach it! Compare what we have vs. the previous guy's sequence + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Update the global maximum after finishing the inner loop for this number
            maxSequence = Math.max(maxSequence, dp[i]);
        }

        return maxSequence;
    }
}