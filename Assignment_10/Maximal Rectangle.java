import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] arr = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j]++;
                }
            }
            ans = Math.max(ans, largestHistogram(arr));
        }
        return ans;
    }

    public static int largestHistogram(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int h = arr[st.pop()];
                int r = i;
                if (st.isEmpty()) {
                    ans = Math.max(h * r, ans);
                } else {
                    int l = st.peek();
                    int area = h * (r - l - 1);
                    ans = Math.max(area, ans);
                }
            }
            st.push(i);
        }

        int r = arr.length;
        while (!st.isEmpty()) {
            int h = arr[st.pop()];
            if (st.isEmpty()) {
                ans = Math.max(h * r, ans);
            } else {
                int l = st.peek();
                int area = h * (r - l - 1);
                ans = Math.max(area, ans);
            }
        }
        return ans;
    }

  
    /*
    Time Complexity (TC):
    - For each row, we build a histogram: O(cols)
    - largestHistogram() processes each bar at most twice (push + pop) using a stack: O(cols)
    - Total for all rows: O(rows * cols)

    Space Complexity (SC):
    - Stack in largestHistogram can store at most cols elements: O(cols)
    - Histogram array arr of size cols: O(cols)
    - Total space: O(cols)
    */
}
