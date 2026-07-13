class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Edge cases
        if (nums == null || nums.length == 0) return new int[0];
        
        // The array to store our final high scores
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        
        // Our Gladiator Arena (Stores INDICES, not the actual numbers!)
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            // ==========================================
            // 1. FRONT DOOR: Kick out the old guys!
            // ==========================================
            // If the guy at the front of the line has an index that is 
            // no longer inside our window ( i - k + 1 ), kick him out!
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.removeFirst();
            }
            
            // ==========================================
            // 2. BACK DOOR: Kill the weak guys!
            // ==========================================
            // While the line isn't empty, and the new guy nums[i] is BIGGER 
            // than the guy at the back of the line... kill the back guy!
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            
            // The new guy finally enters the arena
            q.addLast(i);
            
            // ==========================================
            // 3. RECORD THE SCORE
            // ==========================================
            // We only start recording scores once our window has expanded 
            // to size 'k' (when i >= k - 1)
            if (i >= k - 1) {
                // The King is always at the front! (Translate his ID badge back to his strength)
                result[resultIndex] = nums[q.peekFirst()];
                resultIndex++;
            }
        }
        
        return result;
    }
}