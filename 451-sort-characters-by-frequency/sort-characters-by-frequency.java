
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) -> map.get(b)-map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char i:list){
            for(int j=0;j<map.get(i);j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}