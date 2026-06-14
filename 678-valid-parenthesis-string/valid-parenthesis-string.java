class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for(char ch : s.toCharArray()){
            switch(ch){
                case '(':
                    low++;
                    high++;
                    break;
                
                case ')':
                    low--;
                    high--;
                    break;
                
                case '*':
                    low--;
                    high++;
                    break;
            }
            if(high<0) return false;
            low = Math.max(low, 0);
        }
        return low==0;
    }
}