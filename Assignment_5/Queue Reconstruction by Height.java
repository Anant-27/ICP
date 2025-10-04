class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            else{
                return b[0]-a[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<people.length;i++){
            int idx=people[i][1];
            list.add(idx,people[i]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}



/*
Complexity Analysis:

Time Complexity (TC):
- Sorting: O(n log n)
- Inserting into list at index: O(n^2) in worst case
- Overall TC: O(n^2)

Space Complexity (SC):
- List used for intermediate storage: O(n)
- Result array: O(n)
- Overall SC: O(n)
*/


/*
Test Cases:

1. Input: 
people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output:
[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

2. Input: 
people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output:
[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

3. Input: 
people = [[1,0]]
Output:
[[1,0]]

*/
