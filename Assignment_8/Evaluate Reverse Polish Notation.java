class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int b=st.pop();
                int a=st.pop();
                if(tokens[i].equals("+")){
                    st.push(a+b);
                }
                else if(tokens[i].equals("-")){
                    st.push(a-b);
                }
                else if(tokens[i].equals("*")){
                    st.push(a*b);
                }
                else if(tokens[i].equals("/")){
                    st.push(a/b);
                }
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}



/*
-------------------------------------------
TIME COMPLEXITY:
-------------------------------------------
O(n)
→ Each token is processed once.
→ Each stack operation (push/pop) takes O(1).

-------------------------------------------
SPACE COMPLEXITY:
-------------------------------------------
O(n)
→ In the worst case, all tokens are numbers before any operator,
   so stack can store up to n elements.

-------------------------------------------
TEST CASE 1:
-------------------------------------------
Input: ["2","1","+","3","*"]

Step-by-step:
Stack: []
Push 2 → [2]
Push 1 → [2,1]
"+" → Pop 1,2 → Push (2+1)=3 → [3]
Push 3 → [3,3]
"*" → Pop 3,3 → Push (3*3)=9 → [9]

Output: 9 

-------------------------------------------
TEST CASE 2:
-------------------------------------------
Input: ["4","13","5","/","+"]

Stack: []
Push 4 → [4]
Push 13 → [4,13]
Push 5 → [4,13,5]
"/" → Pop 5,13 → Push (13/5)=2 → [4,2]
"+" → Pop 2,4 → Push (4+2)=6 → [6]

Output: 6 

-------------------------------------------
TEST CASE 3:
-------------------------------------------
Input: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]

Output: 22 

-------------------------------------------
FINAL SUMMARY:
-------------------------------------------
Approach: Stack-based evaluation
Time Complexity: O(n)
Space Complexity: O(n)
-------------------------------------------
*/
