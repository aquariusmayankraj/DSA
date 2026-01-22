class Solution:
    def generate(self, numRows: int):
        result = []

        for i in range(numRows):
            row = []
            val = 1

            for j in range(i + 1):
                row.append(val)
                val = val * (i - j) // (j + 1)

            result.append(row)

        return result
