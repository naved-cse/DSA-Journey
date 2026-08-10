class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // STEP 1: Pair them up! O(N)
        // Create a 2D array to hold [position, speed] for each car
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        // STEP 2: Sort them by position! O(N log N)
        // We sort based on position (cars[0]). 
        // Java sorts smallest to largest by default (furthest back to closest to target)
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        // STEP 3: The Stack Logic! O(N)
        Deque<Double> stack = new ArrayDeque<>();
        
        // We loop BACKWARDS (starting from the car closest to the finish line)
        for (int i = n - 1; i >= 0; i--) {
            
            // Calculate time = (Target - Position) / Speed
            double time = (target - cars[i][0]) / cars[i][1];
            
            // If the stack is empty, this car forms the first fleet!
            if (stack.isEmpty()) {
                stack.push(time);
            } 
            // If this car takes MORE time than the fleet in front of it, 
            // it can never catch up. It forms a brand NEW fleet!
            else if (time > stack.peek()) {
                stack.push(time);
            }
            // (If time <= stack.peek(), it catches up and joins the fleet. 
            // We do nothing, which naturally ignores it!)
        }
        
        // The number of fleets is just the number of times stored in the stack
        return stack.size();
    }
}