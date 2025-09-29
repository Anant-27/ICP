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
        int[] result = spiralOrder(matrix);
        for (int val : result) {
            System.out.print(val + " ");
        }
        sc.close();
    }

    public static int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;

        int minr = 0, minc = 0, maxr = m - 1, maxc = n - 1;
        int total = m * n, count = 0;

        while (count < total) {
            for (int i = minc; i <= maxc && count < total; i++) {
                result[index++] = matrix[minr][i];
                count++;
            }
            minr++;

            for (int i = minr; i <= maxr && count < total; i++) {
                result[index++] = matrix[i][maxc];
                count++;
            }
            maxc--;

            for (int i = maxc; i >= minc && count < total; i--) {
                result[index++] = matrix[maxr][i];
                count++;
            }
            maxr--;

            for (int i = maxr; i >= minr && count < total; i--) {
                result[index++] = matrix[i][minc];
                count++;
            }
            minc++;
        }
        return result;
    }
}

/*
--------------------
Time Complexity: O(m * n)
Space Complexity: O(m * n) (for result array)
--------------------

Test Cases:

1. Input:
3 3
1 2 3
4 5 6
7 8 9
Output:
1 2 3 6 9 8 7 4 5

2. Input:
3 4
1 2 3 4
5 6 7 8
9 10 11 12
Output:
1 2 3 4 8 12 11 10 9 5 6 7

3. Input:
1 4
1 2 3 4
Output:
1 2 3 4

4. Input:
4 1
1
2
3
4
Output:
1 2 3 4
*/
