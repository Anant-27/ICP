class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] tokens=path.split("/");
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals(".") || tokens[i].equals("")){
                continue;
            }
            if(tokens[i].equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(tokens[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String words:st){
            sb.append("/").append(words);
        }
        if(sb.length()==0){
            return "/";
        }
        return sb.toString();
    }
}



/**
Time Complexity (TC): O(n)
   → Each directory token is processed once.
   → Stack operations (push/pop) are O(1).

Space Complexity (SC): O(n)
   → Stack stores valid directory names.

Test Cases:
---------------------------------
Input: "/home/"
Output: "/home"
Explanation: Single directory → remains unchanged.

Input: "/../"
Output: "/"
Explanation: Moving above root is ignored → stays at root.

Input: "/home//foo/"
Output: "/home/foo"
Explanation: Consecutive slashes are treated as one.

Input: "/a/./b/../../c/"
Output: "/c"
Explanation: "./" → current directory; "../" → go up one directory.

Input: "/"
Output: "/"
Explanation: Already at root.
*/






