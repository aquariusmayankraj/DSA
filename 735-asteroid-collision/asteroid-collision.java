class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int a = asteroids[i];
            boolean destroy = false;
            while(!stack.isEmpty() && stack.peek()>0 && a<0){
                if(stack.peek()<-a){
                    stack.pop();
                    continue;
                }
                else if(stack.peek()== -a){
                    stack.pop();
                }
                destroy = true;
                break;
            }

            if(!destroy){
                stack.push(a);
            }
        }
    int [] result = new int[stack.size()];
    for(int i=result.length-1;i>=0;i--){
        result[i] = stack.pop();
    }
    return result;
    }

}