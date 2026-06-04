class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int MaxLength =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                MaxLength = Math.max(MaxLength, 2*right);
            }
            else if(right>left){
                left=right=0;
            }
        }

        //reset karna hoga pointers ko iske baad yahi main catch hain iss problem ka 
        left = right = 0;
        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i)=='('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                MaxLength = Math.max(MaxLength, 2*left);
            }
            else if(left>right){
                left=right=0;
            }
        }
        return MaxLength;
    }
}