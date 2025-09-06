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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        branch(root);
        return maxSum;
    }

    private int branch(TreeNode node){
        if (node == null) return 0;

        int left = Math.max(0, branch(node.left));
        int right = Math.max(0, branch(node.right));

        int pathSum = left + right + node.val;
        maxSum = Math.max(maxSum, pathSum);

        return node.val + Math.max(left, right);
    }
}
