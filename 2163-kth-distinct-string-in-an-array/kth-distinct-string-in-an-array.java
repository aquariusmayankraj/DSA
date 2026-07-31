class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String num:arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(String num: arr){
            if(map.get(num)==1){
                k--;
                if(k==0){
                    return num;
                }
            }
        }
        return "";
    }
}