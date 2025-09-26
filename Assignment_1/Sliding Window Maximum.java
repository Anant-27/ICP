import java.util.*;

public class sliding_window_max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = maxSlidingWindow(nums, k);
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
        sc.close();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                ans[j++] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}

/*
--------------------
Time Complexity: O(n)
Space Complexity: O(k)
--------------------

Test Cases:

1. Input:
8
1 3 -1 -3 5 3 6 7
3
Output:
3 3 5 5 6 7

2. Input:
1
1
1
Output:
1

3. Input:
2
9 11
2
Output:
11

4. Input:
4
4 3 2 1
2
Output:
4 3 2

5. Input:
5
2 2 2 2 2
3
Output:
2 2 2
*/
