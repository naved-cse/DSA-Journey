class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();

        backtrack(result, bucket, candidates, target, 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] candidates, int target, int start, int currentSum){
        if (currentSum == target){
            result.add(new ArrayList<>(bucket));
            return;
        }
        if (currentSum > target){
            return;
        }
        for (int i = start; i < candidates.length; i++){
            bucket.add(candidates[i]);
                backtrack(result, bucket, candidates, target, i, currentSum + candidates[i]);

                bucket.remove(bucket.size() - 1);
            
        }
    }
}