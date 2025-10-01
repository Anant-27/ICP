import java.util.*;

public class min_arrows {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt(); 
            points[i][1] = sc.nextInt(); 
        }
        int result = findMinArrowShots(points);
        System.out.println(result);
        sc.close();
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int arrows = 1;
        int prevStart = points[0][0];
        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];
            if (currStart > prevEnd) {
                arrows++;
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                prevStart = Math.max(prevStart, currStart);
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }
        return arrows;
    }
}

// --------------------
// Time Complexity: O(n log n)
// Space Complexity: O(1)
// --------------------




/*
Test Cases:

1. Single balloon
Input:
1
1 6
Output:
1
Explanation: Only one balloon → need 1 arrow.

2. Non-overlapping balloons
Input:
3
1 2
3 4
5 6
Output:
3
Explanation: Each balloon is separate → need 3 arrows.

3. Fully overlapping balloons
Input:
3
1 10
2 6
3 5
Output:
1
Explanation: All overlap → one arrow is enough.

4. Partially overlapping balloons
Input:
4
1 3
2 4
5 7
6 8
Output:
2
Explanation: First two overlap (1 arrow), last two overlap (1 arrow).

5. Edge case: no balloons
Input:
0
Output:
0
Explanation: No balloons, no arrows needed.
*/
