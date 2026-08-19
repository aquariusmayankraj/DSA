class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        int sub = 0;
        for (int i = 0; i < s.length(); i += 2) {
            sum += s.charAt(i) - '0';
        }
        for (int i = 1; i < s.length(); i += 2) {
            sub += s.charAt(i) - '0';
        }
        return sum - sub;
    }
}