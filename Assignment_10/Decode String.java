import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                val = val * 10 + (ch - '0');
            } else if (ch == '[') {
                num.push(val);
                str.push(cur);
                cur = new StringBuilder();
                val = 0;
            } else if (ch == ']') {
                int k = num.pop();
                StringBuilder tmp = str.pop();
                for (int j = 0; j < k; j++) {
                    tmp.append(cur);
                }
                cur = tmp;
            } else {
                cur.append(ch);
            }
        }

        return cur.toString();
    }

  
    /*
    Time Complexity: O(m)
    Space Complexity: O(m)
    */
}
