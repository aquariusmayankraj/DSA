class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }
        if(set.isEmpty()){
            return s.length();
        }
        else{
            return s.length()-set.size()+1;
        }
    }
}