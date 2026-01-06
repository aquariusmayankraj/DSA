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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1, maxLevel = 1, maxSum = Integer.MIN_VALUE;
        
        while(!q.isEmpty()) {
            int size = q.size(), sum = 0;
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                sum += n.val;
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            if(sum > maxSum) { 
                maxSum = sum; 
                maxLevel = level; 
            }
            level++;
        }
        return maxLevel;
    }
}
