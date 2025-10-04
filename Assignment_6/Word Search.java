class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean ans=search(board,i,j,word,0);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean search(char[][] board,int i,int j,String word,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(idx)){
            return false;
        }
        board[i][j]='*';
        int[] r={1,-1,0,0};
        int[] c={0,0,1,-1};
        for(int a=0;a<r.length;a++){
            boolean ans=search(board,i+r[a],j+c[a],word,idx+1);
            if(ans==true){
                return true;
            }
        }
        board[i][j]=word.charAt(idx);
        return false;
    }
}

/*
Word Search Problem (Backtracking)

Time Complexity:
- Worst case: O(R * C * 4^L)
  where R = rows, C = cols, L = length of word
- Explanation: For each cell (R*C), we may explore 4 directions for up to L characters.

Space Complexity:
- O(L) recursion stack (L = length of word).
- No extra data structures used except recursion + constant arrays.

Test Cases:
1. board = [["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]], word = "ABCCED" → true
2. board = [["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]], word = "SEE" → true
3. board = [["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]], word = "ABCB" → false
*/
