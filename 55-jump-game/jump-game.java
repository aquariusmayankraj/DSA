class Solution {
    public boolean canJump(int[] nums) {
        int value = 0;
        for(int i=0;i<nums.length;i++){
            if(i>value){
                return false;
            }
            value = Math.max(value,i+nums[i]);
        }
        return true;
    }
}