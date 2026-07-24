class Solution {
    public String reverseWords(String s) {
        String[] ans = s.split(" ");
        for(int i=0;i<ans.length;i++){
            ans[i] = new StringBuilder(ans[i]).reverse().toString();
        }
        return String.join(" ",ans);
    }
}