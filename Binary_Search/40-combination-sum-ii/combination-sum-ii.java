class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        
        Arrays.sort(candidates);

        backtrack(result, bucket, candidates, target, 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int[] candidates, int target, int start, int currentSum){
        if (currentSum == target){
            result.add(new ArrayList<>(bucket));
        }
        if (currentSum > target){
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (currentSum + candidates[i] > target){
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            bucket.add(candidates[i]);

            backtrack(result, bucket, candidates, target, i+1, currentSum + candidates[i]);

            bucket.remove(bucket.size() - 1);
        }
    }
}