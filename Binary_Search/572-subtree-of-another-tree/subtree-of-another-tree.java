class Solution {
    
    // ==========================================
    // THE SEARCH PARTY (Lenient Boss: ||)
    // Walks through the main tree looking for the start of a match
    // ==========================================
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 1. BASE CASE: If the main tree is completely empty, it's a dead end.
        if (root == null) {
            return false;
        }
        
        // 2. CALL THE INSPECTOR: Does a perfect match start exactly here?
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // 3. KEEP SEARCHING: Is it hiding down the left side OR the right side?
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    
    // THE INSPECTOR (Strict Boss: &&)
    // Checks if two trees are identical clones all the way to the bottom
    
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Both nodes are empty spaces (Perfect match!)
        if (p == null && q == null) {
            return true;
        }
        
        // 2. Only ONE is empty (Structure mismatch!)
        if (p == null || q == null) {
            return false;
        }
        
        // 3. Values match AND left branches match AND right branches match 
        return (p.val == q.val) 
            && isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}