class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        backtrack(result, bucket, nums, visited);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[]nums, boolean[] visited){
        if( bucket.size() == nums.length){
            result.add(new ArrayList<>(bucket));
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i]){
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }

            bucket.add(nums[i]);
            visited[i] = true;

            backtrack(result, bucket, nums, visited);

            bucket.remove(bucket.size() - 1);
            visited[i] = false;
        }
    }
}