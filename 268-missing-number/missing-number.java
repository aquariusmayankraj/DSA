class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length; 
        int sum = n * (n + 1) / 2;
        int s = 0;
        for (int num : arr) {
            s += num;
        }
        return sum - s;
    }
}
