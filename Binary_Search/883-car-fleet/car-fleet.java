import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
        // Combine position and speed into a 2D array
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        // Sort the cars by position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        int fleets = 0;
        double maxTimeSeen = 0.0;
        
        // Iterate from the car closest to the target to the furthest
        for (int i = 0; i < n; i++) {
            // Calculate time to reach the target for the current car
            double timeToTarget = (double) (target - cars[i][0]) / cars[i][1];
            
            // If this car's time is strictly greater than the max time seen so far,
            // it will never catch up to the fleet ahead of it. It forms a new fleet.
            if (timeToTarget > maxTimeSeen) {
                fleets++;
                maxTimeSeen = timeToTarget;
            }
        }
        
        return fleets;
    }
}