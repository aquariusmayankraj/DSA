class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for( int num : nums){
            if(visited.contains(num)){
                duplicates.add(num);
            }
            else{
                visited.add(num);
            }
        }
    return duplicates;
    }
}