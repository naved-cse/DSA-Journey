// Problem: Find the Highest Altitude (LeetCode 1732)
// Difficulty: Easy
// Approach: I kept a variable altitude to track the current height as I added each gain value step by step.
// At the same time, I compared it with highestaltitude and updated whenever the current altitude was greater.
// In the end, highestaltitude holds the maximum altitude reached during the journey.

class Solution {
    public int largestAltitude(int[] gain) {

        // creating an array result (not actually needed, but initially thought to store altitudes)
        int[] result = new int[gain.length];

        // variable to keep track of current altitude as we move step by step
        int altitude = 0;

        // variable to store the highest altitude reached so far
        int highestaltitude = 0;

        // iterating through each gain value
        for (int i = 0; i < gain.length; i++) {

            // updating current altitude by adding the gain at this step
            altitude += gain[i];

            // checking if the current altitude is greater than the highest recorded
            if (altitude > highestaltitude) {

                // updating highest altitude to the new maximum
                highestaltitude = altitude;
            }
        }

        // returning the maximum altitude reached during the journey
        return highestaltitude;
    }
}