import java.util.*;

class StockSpanner {
    Stack<int[]> st;
  
    public StockSpanner() {
        st = new Stack<>();
    }
    public int next(int price) {
        int count = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            count += st.pop()[1];
        }
        int[] arr = new int[2];
        arr[0] = price;  
        arr[1] = count; 
        st.push(arr);
        return count;
    }
}

/**
Time Complexity (TC): Amortized O(1) per operation
   → Each price is pushed and popped at most once from the stack.
   → So for n calls, total O(n).

Space Complexity (SC): O(n)
   → Stack stores at most n pairs (price, span) in the worst case.

Test Cases:
---------------------------------
Input:
["StockSpanner","next","next","next","next","next","next","next"]
[[],[100],[80],[60],[70],[60],[75],[85]]

Output:
[null,1,1,1,2,1,4,6]

Explanation:
Day 1: price=100 → span=1 (no previous higher)
Day 2: price=80  → span=1
Day 3: price=60  → span=1
Day 4: price=70  → span=2 (includes day 3)
Day 5: price=60  → span=1
Day 6: price=75  → span=4 (includes days 5,4,3)
Day 7: price=85  → span=6 (includes all except first day)

Input:
["StockSpanner","next","next","next","next"]
[[],[31],[41],[48],[59]]

Output:
[null,1,2,3,4]

Explanation:
Each next price is higher than before, so span keeps increasing.
*/
