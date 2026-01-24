# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(node):
            if not node:
                return 0
            leftHeight = height(node.left)
            if leftHeight == -1:
                return -1

            rightHeight = height(node.right)
            if rightHeight == -1:
                return -1
            
            if abs(leftHeight - rightHeight) >1:
                return -1
            return max(leftHeight, rightHeight)+1
        return height(root)!=-1