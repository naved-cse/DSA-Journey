class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        
        backtrack(result, bucket, nums, 0); // Start at index 0
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] nums, int start) {
        
        // 1. THE IMMEDIATE PHOTO
        // We take a snapshot the exact second we enter the function.
        // The very first time this runs, the bucket is empty [], which perfectly captures the empty subset!
        result.add(new ArrayList<>(bucket));

        // 2. THE DYNAMIC LOOP
        // We iterate through the actual array instead of counting to 'n'
        for (int i = start; i < nums.length; i++) {
            
            // A. CHOOSE
            bucket.add(nums[i]);
            
            // B. EXPLORE 
            // Pass i + 1 to move forward. This prevents backwards duplicates like [2, 1]!
            backtrack(result, bucket, nums, i + 1);
            
            // C. UN-CHOOSE
            bucket.remove(bucket.size() - 1);
        }
    }
}