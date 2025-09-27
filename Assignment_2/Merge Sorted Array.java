import java.util.*;

public class merge_sorted_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums1 = new int[m + n];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        merge(nums1, m, nums2, n);
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
        sc.close();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

// --------------------
// Time Complexity: O(m + n)
// Space Complexity: O(1)
// --------------------


/*
Test Cases:

1. Example 1
Input:
3 3
1 2 3
2 5 6
Output:
1 2 2 3 5 6
Explanation: Merge [1,2,3] and [2,5,6] → [1,2,2,3,5,6].

2. Example 2
Input:
1 0
1
Output:
1
Explanation: Merge [1] and [] → [1].

3. Example 3
Input:
0 1
1
Output:
1
Explanation: Merge [] and [1] → [1].

4. Case with duplicates
Input:
3 3
2 2 3
1 2 2
Output:
1 2 2 2 2 3
Explanation: Handles duplicates correctly.

5. Case where nums2 is larger
Input:
2 4
4 5
1 2 3 6
Output:
1 2 3 4 5 6
Explanation: Correctly merges when nums2 has more elements.
*/
