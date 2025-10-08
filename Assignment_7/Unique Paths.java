import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, m, n, dp);   
    }
    public int helper(int i, int j, int m, int n, int[][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = helper(i + 1, j, m, n, dp);
        int right = helper(i, j + 1, m, n, dp);
        return dp[i][j] = down + right;
    }
}


/*
Time Complexity (TC): O(m * n)
   → Each cell (i, j) is computed once and stored in dp.

Space Complexity (SC): O(m * n)
   → For the dp array + O(m + n) recursion stack space (due to recursion depth).

Test Cases:

-------------------------------
Input: m = 3, n = 7
Output: 28
Explanation: There are 28 unique paths.

Input: m = 3, n = 2
Output: 3
Explanation: Paths are Right→Down→Down, Down→Right→Down, Down→Down→Right.

Input: m = 1, n = 1
Output: 1
Explanation: Only one cell, so one unique path.

Input: m = 2, n = 3
Output: 3
Explanation: Paths → DDR, DRD, RDD.

Input: m = 10, n = 10
Output: 48620
Explanation: Large grid, memoization efficiently computes result.
*/
