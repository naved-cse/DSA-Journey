class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();

        backtrack(result, bucket, nums, 0);

        return result; 
    }

    private void backtrack(List<List<Integer>> result, List<Integer>bucket, int[] nums, int start) {

        result.add(new ArrayList<>(bucket));

        for (int i = start; i < nums.length; i++){
        bucket.add(nums[i]);

        backtrack(result, bucket, nums, i + 1);

        bucket.remove(bucket.size() - 1);
        }
    }
}