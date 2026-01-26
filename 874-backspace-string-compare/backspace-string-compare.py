class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        stack_s = []
        stack_t = []

        for ch in s:
            if ch!='#':
                stack_s.append(ch)
            elif stack_s:
                stack_s.pop()
        for ch in t:
            if ch!='#':
                stack_t.append(ch)
            elif stack_t:
                stack_t.pop()
        return stack_s == stack_t
