class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int length = 0;
        for(int c :map.values()){
            length += (c/2)*2;
        }
        if(length<s.length()){
            length++;
        }
        return length;
    }
}