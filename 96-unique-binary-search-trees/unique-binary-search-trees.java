class Solution {
    public int numTrees(int n) {
        return count(n);
    }
    public int count(int n){
        if(n<=1) return 1;
        int total = 0;
        for(int root=1;root<=n;root++){
            int left = count(root-1);
            int right = count(n-root);
            total = total + left*right;
        }
        return total;
    }
}