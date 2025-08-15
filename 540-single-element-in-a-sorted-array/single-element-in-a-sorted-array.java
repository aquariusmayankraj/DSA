class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        if (n == 1) return arr[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

           
            if (arr[mid] == arr[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}
