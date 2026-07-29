/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            // Safe mid calculation to avoid overflow!
            int mid = left + (right - left) / 2;
            
            int result = guess(mid); // Call the API once and save the answer
            
            if (result == 0) {
                return mid; // Jackpot!
            } else if (result == -1) {
                right = mid - 1; // Our guess was too high
            } else {
                left = mid + 1; // Our guess was too low (result == 1)
            }
        }
        
        return -1; // The code will never actually reach here if the number exists
    }
}