class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1. Find the boundaries for our Binary Search
        int left = 1; // Minimum possible speed
        int right = 0; // Maximum possible speed (the biggest pile)
        
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // 2. Start the Binary Search for the perfect speed
        while (left < right) {
            int mid = left + (right - left) / 2; // 'mid' is our guessed speed
            
            // 3. How long does it take at this guessed speed?
            long totalHours = 0; // MUST be a long to prevent overflow!
            
            for (int pile : piles) {
                // The math trick to round up division: (pile + mid - 1) / mid
                totalHours += (pile + mid - 1) / mid;
            }

            // 4. Did she finish in time?
            if (totalHours <= h) {
                // She finished in time! But can she eat SLOWER?
                // We keep 'mid' safe just in case it's the absolute minimum.
                right = mid;
            } else {
                // She was too slow! She MUST eat faster.
                // We throw away 'mid' because it failed.
                left = mid + 1;
            }
        }

        // When left == right, we have squeezed down to the absolute minimum speed!
        return left;
    }
}