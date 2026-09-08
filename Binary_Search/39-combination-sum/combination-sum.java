class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        // Base case: If remaining target is negative, combination is invalid
        if (remain < 0) {
            return;
        }
        // Base case: If remaining target is exactly zero, we found a valid combination
        else if (remain == 0) {
            result.add(new ArrayList<>(currentList));
        } 
        // Recursive case
        else {
            for (int i = start; i < candidates.length; i++) {
                // Choose the candidate
                currentList.add(candidates[i]);
                
                // Explore further. We pass 'i' (not i+1) because we can reuse the same element
                backtrack(result, currentList, candidates, remain - candidates[i], i);
                
                // Backtrack: remove the last element to try the next candidate
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}