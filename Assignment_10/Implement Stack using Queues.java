import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove(); 
    }
    
    public int top() {
        return queue.peek(); 
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }

    /*
    Time Complexity (TC):
    - push(): O(n) because we rotate the queue (queue.size() - 1) times
    - pop(): O(1) removes the front element
    - top(): O(1) peeks at the front element
    - empty(): O(1)
    
    Space Complexity (SC):
    - Only one queue storing all elements: O(n)
    */
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
