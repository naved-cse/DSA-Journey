class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // 1. Create the answer array (automatically filled with 0s)
        int[] ans = new int[n]; 
        
        // 2. Create our waiting room (Remember: we store INDEXES, not temperatures)
        Deque<Integer> stack = new ArrayDeque<>(); 
        
        for (int i = 0; i < n; i++) {
            // 3. The "Bulldozer" Loop 🚜
            // While the stack is not empty AND today's temp is hotter than the stack's top temp
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                
                int waitingIndex = stack.pop();            // Rescue the cold day
                ans[waitingIndex] = i - waitingIndex;      // Calculate days waited
                
            }
            
            // 4. Today always goes into the waiting room at the end
            stack.push(i);
        }
        
        return ans;
    }
}