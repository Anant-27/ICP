import java.util.*;

public class RescueBoats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }
        int limit = sc.nextInt();
        int ans = numRescueBoats(people, limit);
        System.out.println(ans);
        sc.close();
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }
        return count;
    }
}


// --------------------
// Time Complexity: O(n log n) -> Sorting + O(n) two-pointer
// Space Complexity: O(1) (ignoring input array)
// --------------------



/*
Test Cases:

1. Example 1
Input:
4
3 2 2 1
3
Output:
3
Explanation: Boats: [3], [2,1], [2]

2. Example 2
Input:
5
3 5 3 4 2
5
Output:
4
Explanation: Boats: [3,2], [3], [4], [5]

3. Edge case: everyone fits with pair
Input:
4
1 1 1 1
2
Output:
2
Explanation: Boats: [1,1], [1,1]

4. Single person
Input:
1
4
3
Output:
1
Explanation: Only one boat needed

5. Mixed weights
Input:
6
3 2 2 1 4 1
5
Output:
4
Explanation: Boats: [1,4], [1,3], [2,2], [2]
*/
