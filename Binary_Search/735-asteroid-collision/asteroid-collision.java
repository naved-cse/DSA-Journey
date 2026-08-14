class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 1. Create the Safe Zone (Stack)
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 2. Loop through every asteroid in the given array
        for (int ast : asteroids) {
            
            // Assume the new asteroid is alive until proven otherwise
            boolean survived = true;
            
            // 3. The Battle Loop!
            // FIGHT Condition: Stack not empty AND Stack Top is flying Right AND New is flying Left
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                
                // Scenario A: New asteroid is BIGGER
                if (Math.abs(ast) > stack.peek()) {
                    stack.pop();      // The safe zone asteroid explodes
                    // We DO NOT break. The new asteroid keeps flying left and fights the next one!
                } 
                // Scenario B: They are EXACTLY EQUAL
                else if (Math.abs(ast) == stack.peek()) {
                    stack.pop();      // The safe zone asteroid explodes
                    survived = false; // The new asteroid explodes too
                    break;            // The battle is over!
                } 
                // Scenario C: New asteroid is SMALLER
                else {
                    survived = false; // The new asteroid explodes
                    break;            // The battle is over!
                }
            }
            
            // 4. If the new asteroid survived (or never fought at all), push it to the Safe Zone
            if (survived) {
                stack.push(ast);
            }
        }
        
        // 5. Transfer the survivors from the Stack to the output Array
        int[] result = new int[stack.size()];
        
        // We fill it backwards because Stacks pop Last-In, First-Out!
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}