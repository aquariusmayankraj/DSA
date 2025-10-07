class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length()) return false;
        int counts[] = new int[26];
        int countt[] = new int[26];
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            countt[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(counts[i]!=countt[i])return false;
        }
        return true;
    }
}