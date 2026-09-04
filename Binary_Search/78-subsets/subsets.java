class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from index 0 with an empty current list
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(current));

        // Iterate through the remaining elements
        for (int i = start; i < nums.length; i++) {
            // Include the current element
            current.add(nums[i]);
            
            // Move to the next element
            backtrack(result, current, nums, i + 1);
            
            // Backtrack: remove the last added element to explore other paths
            current.remove(current.size() - 1);
        }
    }
}