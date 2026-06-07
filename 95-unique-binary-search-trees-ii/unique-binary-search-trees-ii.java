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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generate(1,n);
    }
    public List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for(int rootVal=start;rootVal<=end;rootVal++){
            List<TreeNode> leftTrees = generate(start, rootVal-1);
            List<TreeNode> rightTrees = generate(rootVal+1, end);
            for(TreeNode left:leftTrees){
                for(TreeNode right:rightTrees){
                    TreeNode root = new TreeNode(rootVal);
                    root.left= left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}