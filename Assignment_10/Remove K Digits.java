class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char arr : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > arr && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(arr);
        } 
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

  
    /*
    Time Complexity: O(n)
        - Each digit is pushed and popped at most once → O(n)
    Space Complexity: O(n)
        - Stack stores at most n characters
    */
}
