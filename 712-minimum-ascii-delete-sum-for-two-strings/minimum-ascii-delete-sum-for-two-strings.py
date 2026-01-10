class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: int
        """
        m,n = len(s1), len(s2)
        dp = []
        for i in range(m+1):
            row=[]
            for j in range(n+1):
                row.append(0)
            dp.append(row)
        
        for i in range(1,m+1):
            dp[i][0] = dp[i-1][0]+ord(s1[i-1])
        for j in range(1,n+1):
            dp[0][j] = dp[0][j-1]+ord(s2[j-1])

        for i in range(1,m+1):
            for j in range(1,n+1):
                if s1[i-1] == s2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    option1 = ord(s1[i-1])+dp[i-1][j]
                    option2 = ord(s2[j-1])+dp[i][j-1]
                    if option1<option2:
                        dp[i][j] = option1
                    else:dp[i][j] = option2
        return dp[m][n]