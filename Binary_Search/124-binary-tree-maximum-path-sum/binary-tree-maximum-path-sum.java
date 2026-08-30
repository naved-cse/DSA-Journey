class Solution {
    
    // 1. THE GLOBAL SCOREBOARD
    // We keep this outside the function so every node can update it.
    // We start it at the lowest possible number just in case the tree has negatives.
    int globalMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        getBestStraightLine(root); // Start the boomerang
        return globalMax;          // Ignore whatever the root returns, just print the scoreboard!
    }
    
    // ==========================================
    // HELPER: Returns the best straight line to the boss
    // ==========================================
    private int getBestStraightLine(TreeNode node) {
        if (node == null) {
            return 0; // Empty spaces contribute 0 to the sum
        }
        
        // 2. GET BEST LINES FROM CHILDREN
        // If a child gives us a negative number, we use 0 instead (we ignore that path).
        int leftLine = Math.max(0, getBestStraightLine(node.left));
        int rightLine = Math.max(0, getBestStraightLine(node.right));
        
        // 3. JOB 1: THE ARCH (Update the Global Scoreboard)
        // What if the path goes up the left, through me, and down the right?
        int myArch = leftLine + node.val + rightLine;
        globalMax = Math.max(globalMax, myArch);
        
        // 4. JOB 2: PASS THE BATON (Return to Boss)
        // I can only offer my boss one side! I take my own value, plus my best child.
        return node.val + Math.max(leftLine, rightLine);
    }
}