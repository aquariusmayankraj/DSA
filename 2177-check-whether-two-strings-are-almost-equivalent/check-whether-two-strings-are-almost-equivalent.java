class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch:word1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:word2.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        for(char ch='a';ch<='z';ch++){
            int f1 = map1.getOrDefault(ch,0);
            int f2 = map2.getOrDefault(ch,0);
            if(Math.abs(f1-f2)>3){
                return false;
            }
        }
        return true;
    }
}