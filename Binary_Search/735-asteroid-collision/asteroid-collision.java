import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;
            
            // Process collisions: Stack has a right-moving asteroid, current is left-moving
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int currentSize = Math.abs(asteroid);
                
                if (stack.peek() < currentSize) {
                    // The stack asteroid is smaller and explodes. 
                    // Continue the loop to check the next asteroid in the stack.
                    stack.pop();
                    continue;
                } else if (stack.peek() == currentSize) {
                    // Both asteroids are the same size and explode.
                    stack.pop();
                }
                
                // If we reach here, the current asteroid was either equal to 
                // or smaller than the stack asteroid, so it is destroyed.
                destroyed = true;
                break;
            }
            
            // If the current asteroid survived all collisions, add it to the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert the remaining stack back into an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}