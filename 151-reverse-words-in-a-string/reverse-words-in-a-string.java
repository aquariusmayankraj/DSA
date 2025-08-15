class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        
        String[] words = s.split("\\s+");
        
        StringBuilder reverse = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reverse.append(words[i]);
            if (i != 0) {
                reverse.append(" ");
            }
        }
        
        return reverse.toString();
    }
}
