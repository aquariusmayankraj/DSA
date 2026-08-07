class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count=0;
        for(String op:operations){
            if(op.charAt(1)=='+'){
                count++;
            }
            else{
                count--;
            }
        }
        return count;
    }
}