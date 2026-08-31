class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // 1. PERFECT MATCH (Base Case)
        // If BOTH nodes are empty spaces, they match perfectly!
        if (p == null && q == null) {
            return true;
        }
        
        // 2. STRUCTURE MISMATCH (Base Case)
        // If one is empty but the other has a node, the shapes are different!
        if (p == null || q == null) {
            return false;
        }
        
        // 3. THE STRICT BOSS (Recursive Case)
        // - Do our current values match?
        // - AND does my left side perfectly match your left side?
        // - AND does my right side perfectly match your right side?
        return (p.val == q.val) 
            && isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}