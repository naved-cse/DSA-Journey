class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        
        // 1. THE SETUP: Mandatory sorting so identical twins sit next to each other
        Arrays.sort(candidates); 
        
        backtrack(result, bucket, candidates, target, 0, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] candidates, int target, int start, int currentSum) {
        
        // BASE CASES
        if (currentSum == target) {
            result.add(new ArrayList<>(bucket));
            return;
        }
        if (currentSum > target) {
            return;
        }

        // THE DYNAMIC LOOP
        for (int i = start; i < candidates.length; i++) {
            
            // Your Tree Pruning Optimization!
            // Since the array is sorted, if this number busts the target, 
            // every number after it will also bust. Shatter the loop early!
            if (currentSum + candidates[i] > target) {
                break;
            }
            
            // 2. THE TWIN SKIP: The lawnmower that skips duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // A. CHOOSE
            bucket.add(candidates[i]);
            
            // B. EXPLORE 
            // 3. THE WALL: We pass 'i + 1' so the next worker cannot reuse this exact physical item
            backtrack(result, bucket, candidates, target, i + 1, currentSum + candidates[i]);
            
            // C. UN-CHOOSE
            bucket.remove(bucket.size() - 1);
        }
    }
}