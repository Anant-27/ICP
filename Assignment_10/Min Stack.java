import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val); 
        }
    }
    
    public void pop() {
        int removed = stack.pop();
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop(); 
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek(); 
    }

    /*
    Time Complexity (TC):
    - push(): O(1)
    - pop(): O(1)
    - top(): O(1)
    - getMin(): O(1)
    => All operations are constant time.

    Space Complexity (SC):
    - stack stores all elements: O(n)
    - minStack stores only elements that are current minima. In worst case (strictly decreasing input), it can store all elements: O(n)
    => Total space: O(n)
    */
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
