class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek()[0] == ch) {
                st.peek()[1]++;
            } else {
                st.push(new int[]{ch, 1});
            }
            if (st.peek()[1] == k) {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] pair : st) {
            for (int i = 0; i < pair[1]; i++) {
                sb.append((char)pair[0]);
            }
        }
        return sb.toString();
    }

  
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
    */
}
