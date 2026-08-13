class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast : asteroids){
            boolean survived = true;

            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0){
                if (Math.abs(ast) > stack.peek()){
                    stack.pop();
                }
                else if (Math.abs(ast) == stack.peek()){
                    stack.pop();
                    survived = false;
                    break;
                }
                else if (Math.abs(ast) < stack.peek()){
                    survived = false;
                    break;
                }
            }
            if (survived){
                stack.push(ast);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}