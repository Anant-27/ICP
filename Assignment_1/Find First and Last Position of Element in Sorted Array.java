import java.util.*;

public class first_last_index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = searchRange(nums, target);
      
        System.out.println(result[0] + " " + result[1]);
        sc.close();
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = helper(nums, target, true);
        int last = helper(nums, target, false);
        return new int[]{first, last};
    }

    public static int helper(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;  
                } else {
                    left = mid + 1;   
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}



/*
--------------------
Time Complexity: O(log n)
Space Complexity: O(1)
--------------------


Test Cases:

1. Input:
6
5 7 7 8 8 10
8
Output:
3 4

2. Input:
5
2 4 6 8 10
6
Output:
2 2

3. Input:
5
1 2 3 4 5
9
Output:
-1 -1

4. Input:
4
7 7 7 7
7
Output:
0 3

5. Input:
0
7
Output:
-1 -1
*/
