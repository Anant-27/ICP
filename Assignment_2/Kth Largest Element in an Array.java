import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = kthLargest(arr, k);
        System.out.println(ans);
        sc.close();
    }

    public static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.offer(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// --------------------
// Time Complexity: O(n log k)
// Space Complexity: O(k)
// --------------------


/*
Test Cases:

1. Example 1
Input:
6
3 2 1 5 6 4
2
Output:
5
Explanation: Sorted order → [1,2,3,4,5,6], 2nd largest = 5.

2. Example 2
Input:
9
3 2 3 1 2 4 5 5 6
4
Output:
4
Explanation: Sorted order → [1,2,2,3,3,4,5,5,6], 4th largest = 4.

3. Case with duplicates
Input:
5
2 2 2 2 2
3
Output:
2
Explanation: All elements are 2, so kth largest = 2.

4. Case where k = 1 (largest element)
Input:
5
10 4 7 1 9
1
Output:
10
Explanation: Largest element = 10.

5. Case where k = n (smallest element)
Input:
5
10 4 7 1 9
5
Output:
1
Explanation: 5th largest = smallest = 1.
*/
