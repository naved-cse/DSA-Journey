class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; 
        int right = 0;
        
        // 1. Find the boundaries for our "invisible array" of guesses
        for (int weight : weights) {
            left = Math.max(left, weight); // Max package size (smallest possible ship)
            right += weight;               // Sum of all packages (biggest possible ship)
        }
        
        // 2. Binary Search to find the perfect capacity
        while (left < right) {
            int mid = left + (right - left) / 2; // 'mid' is our guessed capacity
            
            // 3. Helper Logic: Simulate loading the ships
            int daysNeeded = 1;
            int currentLoad = 0;
            
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    daysNeeded++;           // Ship is full! Send it away.
                    currentLoad = weight;   // Put this package on the new ship.
                } else {
                    currentLoad += weight;  // Add package to today's ship.
                }
            }
            
            // 4. Did we finish within the required 'days'?
            if (daysNeeded <= days) {
                // We finished in time! But maybe we can build a smaller, cheaper ship?
                // We keep 'mid' safe just in case it's the absolute minimum.
                right = mid; 
            } else {
                // We took too long! The ship is too small. We MUST build a bigger one.
                left = mid + 1; 
            }
        }
        
        // When left == right, we have squeezed down to the absolute minimum capacity!
        return left;
    }
}