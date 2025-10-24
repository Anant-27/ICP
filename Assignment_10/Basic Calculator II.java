class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastOperator = '+';      
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); 
            }          
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastOperator == '+') {
                    stack.push(num);
                } else if (lastOperator == '-') {
                    stack.push(-num);
                } else if (lastOperator == '*') {
                    stack.push(stack.pop() * num);
                } else if (lastOperator == '/') {
                    stack.push(stack.pop() / num);
                }
                lastOperator = c;
                num = 0;
            }
        }
      
        int result = 0;
        for (int val : stack) {
            result += val;
        }
        return result;
    }

  
    /*
    Time Complexity: O(n)
        - We traverse the string once → O(n)
        - Each stack operation is O(1)
    Space Complexity: O(n)
        - Stack stores numbers for + and - operations (at most n elements)
    */
}
