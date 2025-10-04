import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    public static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);                
            backtrack(i + 1, n, k, current, result); 
            current.remove(current.size() - 1);       
        }
    }
}



/*
Combinations (LeetCode 77) - Backtracking

Problem:
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

Time Complexity:
- O(C(n, k) * k)
  There are C(n, k) combinations. Building each combination takes O(k) time.

Space Complexity:
- O(k) recursion stack for backtracking.
- O(C(n, k) * k) for storing all combinations in the result.

Test Cases:
1. n = 4, k = 2 → [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
2. n = 1, k = 1 → [[1]]
3. n = 3, k = 3 → [[1,2,3]]
*/
