class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;
        for(i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i>=0){
            int j;
            for(j=n-1;j>=0;j--){
                if(nums[i] < nums[j]){
                    break;
                }
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    public void swap(int []nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public void reverse(int []nums, int left, int right){
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}