class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        String str = String.valueOf(num);
        for(char ch : str.toCharArray()){
            int digit = ch - '0';
            if(digit%2==0){
                even.add(digit);
            }
            else{
                odd.add(digit);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char ch:str.toCharArray()){
            int digit = ch-'0';
            if(digit%2==0){
                ans.append(even.poll());
            }
            else{
                ans.append(odd.poll());
            }
        }
        return Integer.parseInt(ans.toString());
    }
}