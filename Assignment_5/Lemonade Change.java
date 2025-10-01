import java.util.*;

public class LemonadeChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();        
        int[] bills = new int[n];
        for (int i = 0; i < n; i++) {
            bills[i] = sc.nextInt();   
        }
        boolean ans = lemonadeChange(bills);
        System.out.println(ans);
        sc.close();
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int n = bills.length;
        for (int i = 0; i < n; i++) {
            int bill = bills[i];
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { 
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five =five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}



// --------------------
// Time Complexity: O(n)
// Space Complexity: O(1)
// --------------------

/*
Test Cases:

1. Example 1
Input:
5
5 5 5 10 20
Output:
true
Explanation: Always able to give change.

2. Example 2
Input:
5
5 5 10 10 20
Output:
false
Explanation: Last customer needs $15 change but we only have two $10 bills.

3. Edge case: Only $5 bills
Input:
4
5 5 5 5
Output:
true
Explanation: No change needed.

4. Edge case: First customer gives $10
Input:
1
10
Output:
false
Explanation: Cannot give $5 change with no initial money.

5. Mixed case
Input:
6
5 5 10 5 20 5
Output:
true
Explanation: Change always possible.
*/
