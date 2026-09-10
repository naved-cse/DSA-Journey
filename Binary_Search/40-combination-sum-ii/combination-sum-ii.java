import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the candidates to easily manage duplicates and handle pruning
        Arrays.sort(candidates);
        
        // 2. Start the backtracking process
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int target, int start) {
        // Base case: If target reaches 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early Termination: If the current number is greater than the remaining target, stop
            if (candidates[i] > target) {
                break;
            }

            // Duplicate Avoidance: Skip identical elements at the same decision level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Move forward: include the element
            currentList.add(candidates[i]);

            // Recurse: i + 1 ensures each element is only used once
            backtrack(result, currentList, candidates, target - candidates[i], i + 1);

            // Backtrack: remove the element to try other options
            currentList.remove(currentList.size() - 1);
        }
    }
}
