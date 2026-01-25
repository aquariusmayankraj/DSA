class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return

        stack = [root]
        prev = None

        while stack:
            curr = stack.pop()

            if prev:
                prev.left = None
                prev.right = curr

            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)

            prev = curr
