class Solution {
    public String finalString(String s) {
        String ans = "";
        for(char ch:s.toCharArray()){
            if(ch=='i'){
                ans = new StringBuilder(ans).reverse().toString();
            }
            else{
                ans+=ch;
            }
        } 
        return ans.toString();
    }
}