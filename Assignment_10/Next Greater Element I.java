import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    /*
    Time Complexity: O(n + m)
        - n = length of nums2, m = length of nums1
        - Each element in nums2 is pushed and popped from stack at most once → O(n)
        - Building result for nums1 → O(m)
    Space Complexity: O(n)
        - Stack and HashMap store at most n elements
    */
}
