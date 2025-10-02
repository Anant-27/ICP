import java.util.*;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();  
            intervals[i][1] = sc.nextInt(); 
        }
        int ans = eraseOverlapIntervals(intervals);
        System.out.println(ans);
        sc.close();
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;        
        int prevInterval = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prevInterval][1]) {
                prevInterval = i; 
                count++;
            }
        }
        return intervals.length - count;
    }
}


// --------------------
// Time Complexity: O(n log n) -> Sorting
// Space Complexity: O(1) (ignoring input array)
// --------------------



/*
Test Cases:

1. Example 1
Input:
4
1 2
2 3
3 4
1 3
Output:
1
Explanation: Remove interval [1,3] to make rest non-overlapping.

2. Example 2
Input:
2
1 2
1 2
Output:
1
Explanation: Remove one of the identical intervals.

3. Edge case: no intervals
Input:
0
Output:
0

4. Already non-overlapping
Input:
3
1 2
2 3
3 4
Output:
0
Explanation: All intervals already non-overlapping.

5. Mixed overlaps
Input:
5
1 2
2 3
3 4
1 3
2 4
Output:
2
Explanation: Remove [1,3] and [2,4] to get non-overlapping intervals.
*/
