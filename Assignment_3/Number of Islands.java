class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid==null){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    search(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void search(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        
        search(grid,i+1,j);
        search(grid,i-1,j);
        search(grid,i,j+1);
        search(grid,i,j-1);
    }
}

/*
--------------------
Time Complexity: O(m * n)
Space Complexity: O(m * n) (recursion stack in worst case)
--------------------

Test Cases:

1. Input:
grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output:
1

2. Input:
grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output:
3

3. Input:
grid = [
  ['0','0','0'],
  ['0','0','0'],
  ['0','0','0']
]
Output:
0

4. Input:
grid = [
  ['1','1','1'],
  ['1','1','1'],
  ['1','1','1']
]
Output:
1

5. Input:
grid = [
  ['1','0','1'],
  ['0','1','0'],
  ['1','0','1']
]
Output:
5
*/
