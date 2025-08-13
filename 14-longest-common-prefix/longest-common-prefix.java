class Solution {
    public String longestCommonPrefix(String[] s) {
        if(s == null || s.length == 0){
            return "";
        }
        for(int i = 0; i < s[0].length(); i++){
            char ch = s[0].charAt(i);
            for(int j = 1; j < s.length; j++){
                if(i == s[j].length() || s[j].charAt(i) != ch){
                    return s[0].substring(0, i);  
                }
            }
        }
        return s[0];
    }
}
