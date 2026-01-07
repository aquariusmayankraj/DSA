class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        subtree_sums = []
        
        def calculate_sum(node):
            if not node:
                return 0
            
            current_sum = node.val + calculate_sum(node.left) + calculate_sum(node.right)
            subtree_sums.append(current_sum)
            return current_sum
        
        total_sum = calculate_sum(root)
        
        max_prod = 0
        for s in subtree_sums:
            product = s * (total_sum - s)
            if product > max_prod:
                max_prod = product
                
        return max_prod % (10**9 + 7)