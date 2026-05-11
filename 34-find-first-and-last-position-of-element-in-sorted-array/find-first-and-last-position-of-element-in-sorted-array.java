class Solution {
    public int lastFind(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }
            else if(nums[mid]==target){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }
    public int firstFind(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstFind(nums, target);
        int last = lastFind(nums, target);
        return new int[]{first, last};
    }
}