class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i = 0; i < n; i++){
            int cur = asteroids[i];
            while(!st.isEmpty() && cur < 0 && st.peek() > 0 ){
                int sum = st.peek() + cur;

                if(sum < 0){
                    st.pop(); 
                }
                else if(sum > 0){
                    cur = 0; 
                    break;
                }
                else{
                    st.pop(); 
                    cur = 0;
                }
            }     
            if(cur != 0){
                st.push(cur); 
            }
        }
        int[] ans = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }

  
    /*
    Time Complexity (TC):
    - Each asteroid is pushed and popped at most once from the stack.
    - Hence, the total time complexity is O(n), where n = asteroids.length.

    Space Complexity (SC):
    - Stack may store all asteroids in the worst case (no collisions occur).
    - Hence, the space complexity is O(n).
    */
}
