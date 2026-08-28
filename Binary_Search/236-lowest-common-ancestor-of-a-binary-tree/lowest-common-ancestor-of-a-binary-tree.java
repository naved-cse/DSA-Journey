class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // 1. BASE CASE (Dead End)
        // If we hit an empty leaf, return null (we found nothing here).
        if (root == null) {
            return null;
        }
        
        // 2. THE DISCOVERY (The Direct Boss Scenario)
        // If we are currently standing on P or Q, stop searching! 
        // Instantly return ourselves back up the chain.
        if (root == p || root == q) {
            return root;
        }
        
        // 3. THE THROW (Diving Down)
        // We didn't find them yet, so call our left and right children to keep looking.
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
        
        // 4. THE CATCH (The "Bend" Scenario)
        // If BOTH left and right threw a node back up to us, we are the intersection!
        // We are the LCA, so we return OURSELVES.
        if (leftSearch != null && rightSearch != null) {
            return root;
        }
        
        // 5. THE PASS-THROUGH
        // If only ONE side found a node (or neither did), just pass whatever we found 
        // further up to our boss. 
        if (leftSearch != null) {
            return leftSearch;
        } else {
            return rightSearch;
        }
    }
}