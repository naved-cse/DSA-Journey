class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();

        backtrack(result, bucket, 1, n, k);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> bucket, int start, int n , int k) {
        if (bucket.size() == k){
            result.add(new ArrayList<>(bucket));
            return;
        }
        for (int i = start; i <= n; i++){
            bucket.add(i);

            backtrack(result, bucket, i+1, n, k);

            bucket.remove(bucket.size() - 1);
        }
    }
}