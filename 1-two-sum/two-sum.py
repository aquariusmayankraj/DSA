class Solution:
    def twoSum(self, nums, target):
        d={}
        for i in range(len(nums)):
            need = target-nums[i]
            if need in d:
                return [d[need],i]
            d[nums[i]]=i

        