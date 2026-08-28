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
    int dx=-1;
    int dy=-1;
    TreeNode px=null;
    TreeNode py=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        find(root, null, 0, x, y);
        return dx==dy && px!=py;
    }
    public void find(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root==null)return;

        if(root.val==x){
            dx=depth;
            px=parent;
        }
        if(root.val==y){
            dy=depth;
            py=parent;
        }
        find(root.left, root, depth+1, x, y);
        find(root.right, root, depth+1, x, y);
    }
}