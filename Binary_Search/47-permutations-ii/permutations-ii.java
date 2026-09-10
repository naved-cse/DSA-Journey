class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        // CRITICAL: You must sort first so the twins sit next to each other!
        Arrays.sort(nums); 
        
        backtrack(result, bucket, nums, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] nums, boolean[] visited) {
        if (bucket.size() == nums.length) {
            result.add(new ArrayList<>(bucket));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 1. STANDARD SKIP: Is this exact physical item already in the bucket?
            if (visited[i]) {
                continue;
            }
            
            // 2. THE TWIN SKIP: Did my identical twin already do this exact work?
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            // Choose, Explore, Un-choose (Exactly the same as before!)
            bucket.add(nums[i]);
            visited[i] = true;
            
            backtrack(result, bucket, nums, visited);
            
            bucket.remove(bucket.size() - 1);
            visited[i] = false;
        }
    }
}