class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        current_sum = 0
        maxi = nums[0]
        for num in nums:
            current_sum += num
            maxi = max(maxi,current_sum)
            if current_sum<0:
                current_sum = 0
        return maxi