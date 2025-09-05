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
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);
        return diameter;
    }
     private int dia(TreeNode node){
        if(node == null)return 0;

        int left = dia(node.left);
        int right = dia(node.right);
        diameter = Math.max(diameter,left+right);
        return 1 + Math.max(left,right);
     }
}