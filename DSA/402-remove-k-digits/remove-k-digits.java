class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char digit:nums.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(!stack.isEmpty()&&k>0){
            stack.pop();
            k--;
        }
        for(char c:stack){
            sb.append(c);
        }
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0){
            return "0";
        }
        else{
            return sb.toString();
        }
    }
}