from collections import deque

class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []
        
        result = []
        queue = deque([(root, str(root.val))])
        
        while queue:
            node, path = queue.popleft()
            if not node.left and not node.right:
                result.append(path)
            if node.left:
                queue.append((node.left, f"{path}->{node.left.val}"))
            if node.right:
                queue.append((node.right, f"{path}->{node.right.val}"))
        return result