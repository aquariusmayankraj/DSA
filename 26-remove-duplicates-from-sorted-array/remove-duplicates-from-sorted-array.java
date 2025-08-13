class Solution {
    public int removeDuplicates(int arr[]) {
        if (arr.length == 0) return 0; 
        
        int j = 0; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1; 
    }
}

