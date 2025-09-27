import java.util.*;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean ans = isPerfectSquare(n);
        System.out.println(ans);
        sc.close();
    }

    public static boolean isPerfectSquare(int n) {
        if (n < 1) return false;
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long sq = (long) mid * mid;
            if (sq == n) return true;
            else if (sq > n) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}

// --------------------
// Time Complexity: O(log n)
// Space Complexity: O(1)
// --------------------

/*
Test Cases:

1. Input: 16
   Output: true
   Explanation: 4*4 = 16

2. Input: 14
   Output: false
   Explanation: No integer squared = 14

3. Input: 1
   Output: true
   Explanation: 1*1 = 1

4. Input: 808201
   Output: true
   Explanation: 899*899 = 808201

5. Input: 2
   Output: false
   Explanation: No integer squared = 2
*/
