class Solution {
    public char findTheDifference(String s, String t) {
        int xorr = 0;
        for(char ch : s.toCharArray()){
            xorr ^= ch;
        }
        for(char ch : t.toCharArray()){
            xorr ^= ch;
        }
        return (char) xorr;
    }
}