class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int n1 = nums[i];
            int target = -n1;
            twoSum(nums, target, i+1, n-1);
        }
        return result;
    }

    public void twoSum(int[] nums, int target, int left, int right){
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum<target){
                left++;
            }
            else if(sum>target){
                right--;
            }
            else{
                while(left<right && nums[left] == nums[left+1])left++;
                while(left<right && nums[right] == nums[right-1])right--;
                result.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
            }
        }
    }
}