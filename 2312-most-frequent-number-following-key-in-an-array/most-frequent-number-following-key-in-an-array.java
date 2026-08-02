class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] count = new int[1001];
        int max = 0;
        int ans = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                int maxVal = nums[i+1];
                count[maxVal]++;
                if(count[maxVal]>max){
                    max = count[maxVal];
                    ans = maxVal;
                }
            }
        }
        return ans;
    }
}