class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, l2, l1);
        return l1;
    }
    public void backtrack(int[] nums, int target, int sum, int idx, List<Integer> l2, List<List<Integer>> l1) {
        if (sum == target) {
            l1.add(new ArrayList<>(l2));
            return;
        }

        if (sum > target) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;

            if (sum + nums[i] > target) break; 

            l2.add(nums[i]);
            backtrack(nums, target, sum + nums[i], i + 1, l2, l1);
            l2.remove(l2.size() - 1);
        }
    }
}


/*
Combination Sum II — Backtracking Approach:

Time Complexity: O(2^n)
   → Each element can either be included or excluded in a combination.

Space Complexity: O(n)
   → Recursion stack and temporary list (l2) storing current combination.
*/


/*
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: [[1,2,2],[5]]
*/
