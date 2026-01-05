class Solution(object):
    def maxMatrixSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        totalSum=0
        neg=0
        minAbs = float('inf')
        n=len(matrix)

        for i in range(n):
            for j in range(n):
                v=matrix[i][j]
                if v<0:
                    neg+=1
                av = abs(v)
                totalSum+=av
                if av<minAbs:
                    minAbs = av
        if neg%2==0:
            return totalSum
        else:
            return totalSum-2*minAbs

        