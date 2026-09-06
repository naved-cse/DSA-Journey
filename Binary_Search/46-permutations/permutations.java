class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        
        backtrack(result, bucket, nums); // No 'start' variable passed!
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] nums) {
        // 1. BASE CASE: The bucket is full. Take the photo!
        if (bucket.size() == nums.length) {
            result.add(new ArrayList<>(bucket));
            return;
        }

        // 2. THE DYNAMIC LOOP: Every worker looks at the ENTIRE array
        for (int i = 0; i < nums.length; i++) {
            
            // THE SKIP RULE: If the bucket already has this number, skip it!
            if (bucket.contains(nums[i])) {
                continue;
            }
            
            // A. CHOOSE
            bucket.add(nums[i]);
            
            // B. EXPLORE (No i+1. The next worker will also start from 0)
            backtrack(result, bucket, nums);
            
            // C. UN-CHOOSE
            bucket.remove(bucket.size() - 1);
        }
    }
}