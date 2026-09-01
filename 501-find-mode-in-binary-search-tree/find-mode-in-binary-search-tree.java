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
    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);

        if(prev!=null&&root.val==prev){
            count++;
        }else{
            count=1;
        }

        if(count>maxCount){
            maxCount=count;
            ans.clear();
            ans.add(root.val);
        }else if(count==maxCount){
            ans.add(root.val);
        }
        prev=root.val;

        inorder(root.right);
    }
}