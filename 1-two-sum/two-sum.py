class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = []

        for i in range(len(nums)):
            arr.append((nums[i], i))
        arr.sort()

        left = 0
        right = len(arr) - 1

        while left < right:
            s = arr[left][0] + arr[right][0]

            if s == target:
                return [arr[left][1], arr[right][1]]
            elif s < target:
                left += 1
            else:
                right -= 1

        return []
