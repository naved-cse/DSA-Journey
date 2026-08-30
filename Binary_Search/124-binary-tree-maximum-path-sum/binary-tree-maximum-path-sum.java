/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getBestStraightLine(root);
        return globalMax;
    }
    private int getBestStraightLine(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftLine = Math.max(0, getBestStraightLine(node.left));
        int rightLine = Math.max(0, getBestStraightLine(node.right));

        int myArch = leftLine + node.val + rightLine;
        globalMax = Math.max(globalMax, myArch);

        return node.val + Math.max(leftLine, rightLine);
    }
}