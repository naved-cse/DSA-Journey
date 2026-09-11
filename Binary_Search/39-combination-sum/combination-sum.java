class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        
        // Optional: Your brilliant sorting idea! 
        // Arrays.sort(candidates); 
        
        // Start the factory at index 0, with a current sum of 0
        backtrack(result, bucket, candidates, target, 0, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] candidates, int target, int start, int currentSum) {
        
        // 1. BASE CASE A: We hit the exact target! Take a photo.
        if (currentSum == target) {
            result.add(new ArrayList<>(bucket));
            return; // Kill the worker, the job is done.
        }
        
        // 2. BASE CASE B: We busted! (The sum got too big)
        if (currentSum > target) {
            return; // Kill the worker immediately. Don't take a photo!
        }

        // 3. THE DYNAMIC LOOP
        for (int i = start; i < candidates.length; i++) {
            
            // A. CHOOSE
            bucket.add(candidates[i]);
            
            // B. EXPLORE 
            // Notice we pass 'i' instead of 'i + 1' !!!
            // We also add the current number to the running sum.
            backtrack(result, bucket, candidates, target, i, currentSum + candidates[i]);
            
            // C. UN-CHOOSE
            bucket.remove(bucket.size() - 1);
        }
    }
}