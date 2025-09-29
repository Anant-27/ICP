import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
        sc.close();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}


/*
--------------------
Time Complexity: O(log(m * n))
Space Complexity: O(1)
--------------------

Test Cases:

1. Input:
3 4
1 3 5 7
10 11 16 20
23 30 34 60
3
Output:
true

2. Input:
3 4
1 3 5 7
10 11 16 20
23 30 34 60
13
Output:
false

3. Input:
1 1
5
5
Output:
true

4. Input:
2 2
1 2
3 4
0
Output:
false
*/
