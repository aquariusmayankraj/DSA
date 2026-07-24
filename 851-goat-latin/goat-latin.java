class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String ans = "";
        String a = "";
        for (String word : words) {
            a += "a";
            char ch = word.charAt(0);
            if ("aeiouAEIOU".contains(ch + "")) {
                ans += word;
            } 
            else {
                ans += word.substring(1) + ch;
            }
            ans += "ma";
            ans += a;
            ans += " ";
        }
        return ans.trim();
    }
}