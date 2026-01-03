class Solution(object):
    def numOfWays(self, n):
        """
        :type n: int
        :rtype: int
        """
        MOD = 10**9 + 7

        dpA, dpB = 6, 6  
        
        for _ in range(2, n + 1):
            newA = (dpA * 3 + dpB * 2) % MOD
            newB = (dpA * 2 + dpB * 2) % MOD
            dpA, dpB = newA, newB
        
        return (dpA + dpB) % MOD

        